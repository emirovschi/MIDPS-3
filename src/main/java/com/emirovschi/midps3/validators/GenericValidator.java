package com.emirovschi.midps3.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public interface GenericValidator<T> extends Validator
{
    void validateObject(T t, final Errors errors);
}
