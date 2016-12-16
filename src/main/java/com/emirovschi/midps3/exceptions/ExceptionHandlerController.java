package com.emirovschi.midps3.exceptions;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.exceptions.dto.ErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController
{
    @Autowired
    private Converter<Exception, ErrorDTO> errorConverter;

    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorDTO handleNotFoundException(NotFoundException exception)
    {
        return errorConverter.convert(exception);
    }
}
