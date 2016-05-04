package es.dominion.curso.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.dominion.curso.util.dtos.ResultResponseDto;
import es.dominion.curso.util.dtos.ValidationErrorDto;
import es.dominion.curso.util.excepciones.APPErrorUtils;
import es.dominion.curso.util.excepciones.APPException;
import es.dominion.curso.util.excepciones.APPValidationErrorUtils;

public class BaseController {

	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	protected MessageSource messageSource;
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<ResultResponseDto> handleClientErrors(Exception ex) {
		//TODO verificar si es necesario este metodo (ya que tenemos otro parecido)
		//return new ResponseEntity<ResultResponseDto>(new ResultResponseDto(false, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ResultResponseDto>(new ResultResponseDto(false, createError(ex)), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResultResponseDto> handleException(MethodArgumentNotValidException ex) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<ResultResponseDto>(new ResultResponseDto(false, createValidationError(ex)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ResponseEntity<ResultResponseDto> handleServerErrors(Exception ex) {
		//return new ResponseEntity<ResultResponseDto>(new ResultResponseDto(false, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ResultResponseDto>(new ResultResponseDto(false, createError(ex)), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(APPException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ResponseEntity<ResultResponseDto> handleApplicationErrors(APPException ftwe) {
		return new ResponseEntity<ResultResponseDto>(new ResultResponseDto(false, createError(ftwe)), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ValidationErrorDto createError(APPException ftwe) {
		Errors errors = null;
    	APPErrorUtils ftweu = APPErrorUtils.getInstance(messageSource);
		String errorMessage = ftweu.getErrorMensaje(ftwe);
        return APPValidationErrorUtils.fromBindingErrors(errors, errorMessage);
    }
	
	private ValidationErrorDto createError(Exception e) {
		Errors errors = null;
    	String errorMessage = e.getLocalizedMessage(); //"Error no controlado"
        return APPValidationErrorUtils.fromBindingErrors(errors, errorMessage);
    }
	
	private ValidationErrorDto createValidationError(MethodArgumentNotValidException e) {
    	Errors errors = e.getBindingResult();
    	String errorMessage = "Validación erronea. " + errors.getErrorCount() + " error(es)";
        return APPValidationErrorUtils.fromBindingErrors(errors, errorMessage);
    }	
	
}
