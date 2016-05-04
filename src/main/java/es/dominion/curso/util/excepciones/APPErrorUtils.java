package es.dominion.curso.util.excepciones;

import java.sql.SQLException;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;

public class APPErrorUtils {	

	private static final Logger logger = LoggerFactory.getLogger(APPErrorUtils.class);
	
	private static MessageSource messageSource;
	

	private static APPErrorUtils INSTANCE = null;

	// Private constructor suppresses
	private APPErrorUtils(MessageSource messageSource) {
		APPErrorUtils.messageSource=messageSource;
	}

	// creador sincronizado para protegerse de posibles problemas multi-hilo otra prueba para evitar instanciación múltiple
	private synchronized static void createInstance(MessageSource messageSource) {
		if (INSTANCE == null) {
			INSTANCE = new APPErrorUtils(messageSource);
		}
	}

	public static APPErrorUtils getInstance(MessageSource messageSource) {
		if (INSTANCE == null) {
			createInstance(messageSource);
		}
		return INSTANCE;
	}
	
	public String getErrorMensaje(APPException ftwe) {
		logger.error("Código de error: ["+ftwe.getErrorCode()+"]");
		if (ftwe.getPreviousException()!=null) {
			if (ftwe.getPreviousException() instanceof DataIntegrityViolationException ||
					ftwe.getPreviousException() instanceof PersistenceException) {
				printConstraintViolationException(ftwe.getPreviousException());
			} else {
				logger.error("//TODO - ERROR SIN CONTROLAR!!!!");
			}			
		} 

		return messageSource.getMessage(ftwe.getErrorCode(), ftwe.getErrorParameters(), LocaleContextHolder.getLocale());		
	}
		
	public void printConstraintViolationException(Exception ex) {
		
		if (ex!=null && ex.getCause()!=null && (ex.getCause() instanceof javax.validation.ConstraintViolationException || 
				ex.getCause() instanceof org.hibernate.exception.ConstraintViolationException)) {
			
			if (ex.getCause() instanceof javax.validation.ConstraintViolationException) {
				javax.validation.ConstraintViolationException cve = (javax.validation.ConstraintViolationException) ex.getCause();
				logger.error("//TODO - ERROR SIN CONTROLAR!!!!");
				cve.getCause();
			} else {
				org.hibernate.exception.ConstraintViolationException cve = (org.hibernate.exception.ConstraintViolationException) ex.getCause();
				printSQLExceptionError(cve.getSQLException());
			}																	
		} else {
			logger.error("//TODO - ERROR SIN CONTROLAR!!!!");
		}
	}
	
	public void printSQLExceptionError(SQLException sqle) {		
		if (sqle!=null) {
			logger.error("Error de base de datos. ErrorCode: ["+sqle.getErrorCode()+"], SQLState: ["+sqle.getSQLState()+"], Error: ["+sqle.getMessage()+"]");
		} else {
			logger.error("//TODO - ERROR SIN CONTROLAR!!!!");
		}		
	}
}
