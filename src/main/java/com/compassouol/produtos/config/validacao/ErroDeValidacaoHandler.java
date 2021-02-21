package com.compassouol.produtos.config.validacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

// classe que valida o handler enviado pelo cliente chamando os campos do dto
@RestControllerAdvice
public class ErroDeValidacaoHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeValidacaoDto> handle(MethodArgumentNotValidException exception) {
		List<ErroDeValidacaoDto> dto = new ArrayList<>();

		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroDeValidacaoDto erro = new ErroDeValidacaoDto(e.getField(), mensagem);
			dto.add(erro);
		});

		return dto;

	}
	
	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class )
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Map<String, String> handleServiceCallException(MethodArgumentTypeMismatchException e) {
		Map<String, String> errMessages = new HashMap<>();
		errMessages.put("error", "MethodArgumentTypeMismatchException");
		errMessages.put("message", e.getMessage());
		errMessages.put("errorCode", e.getErrorCode());
		return errMessages;
	}
	
	@ExceptionHandler({HttpRequestMethodNotSupportedException.class})
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Map<String, String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex){
		Map<String, String> errMessages = new HashMap<>();
		errMessages.put("error", "HttpRequestMethodNotSupportedException");
		errMessages.put("message", ex.getMessage());
		return errMessages;
	}
	

}
