package es.dominion.curso.util.dtos;

import java.io.Serializable;

public class ResultResponseDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8487663267948085137L;
	private boolean success;
	private ValidationErrorDto validationErrorDto;

	public ResultResponseDto(boolean success, ValidationErrorDto validationErrorDto) {
		this.success = success;
		this.validationErrorDto = validationErrorDto;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success=success;
	}

	public ValidationErrorDto getValidationErrorDto() {
		return validationErrorDto;
	}
	
	public void setValidationErrorDto(ValidationErrorDto validationErrorDto) {
		this.validationErrorDto=validationErrorDto;
	}
	
	

}