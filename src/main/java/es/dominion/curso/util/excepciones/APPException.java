package es.dominion.curso.util.excepciones;

public class APPException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -557618869519335656L;
	
	private String errorCode;
	private Object[] errorParameters;
	private Exception previousException;
	
    public APPException() {
        // TODO Auto-generated constructor stub
    }

    public APPException(String errorCode) {
        this.errorCode=errorCode;
    }

    public APPException(String errorCode, Exception previousException) {
        this.errorCode=errorCode;
        this.previousException=previousException;
    }

    public APPException(String errorCode, Object... errorParameters) {
        this.errorCode=errorCode;
        this.errorParameters=errorParameters;
    }

    public APPException(String errorCode, Exception previousException, Object... errorParameters) {
        this.errorCode=errorCode;
        this.previousException=previousException;
        this.errorParameters=errorParameters;
    }

//    public FTWException(String message) {
//        super(message);
//    }
//
//    public FTWException(Throwable cause) {
//        super(cause);
//        // TODO Auto-generated constructor stub
//    }
//
//    public FTWException(String message, Throwable cause) {
//        super(message, cause);
//        // TODO Auto-generated constructor stub
//    }

    public String getErrorCode(){
		return this.errorCode;
	}
    public Object[] getErrorParameters(){
		return this.errorParameters;
	}
    public Exception getPreviousException(){
		return this.previousException;
	}
}
