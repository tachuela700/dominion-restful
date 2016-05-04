package es.dominion.curso.util.excepciones;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import es.dominion.curso.util.dtos.ValidationErrorDto;

public class APPValidationErrorUtils {

	public static ValidationErrorDto fromBindingErrors(Errors errors, String errorMessage) {
		ValidationErrorDto error = new ValidationErrorDto(errorMessage);
		if (errors != null && errors.getAllErrors() != null && !errors.getAllErrors().isEmpty()) {
			for (ObjectError objectError : errors.getAllErrors()) {
	            error.addValidationError(objectError.getDefaultMessage());
	        }	        
		}
			
        return error;
    }
}
