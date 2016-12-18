package com.emirovschi.midps3.exceptions.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.exceptions.dto.ErrorDTO;
import org.springframework.stereotype.Component;

@Component
public class ErrorConverter implements Converter<Exception, ErrorDTO>
{
    @Override
    public ErrorDTO convert(final Exception exception)
    {
        final ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setError(exception.getClass().getSimpleName());
        errorDTO.setDescription(exception.getMessage());
        return errorDTO;
    }
}
