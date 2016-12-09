package com.emirovschi.midps3.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public abstract class AbstractGenericValidator<T> implements Validator, GenericValidator<T>
{
    private final Class<T> tClass;

    public AbstractGenericValidator(final Class<T> tClass)
    {
        this.tClass = tClass;
    }

    @Override
    public boolean supports(final Class<?> aClass)
    {
        return tClass.isAssignableFrom(aClass);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void validate(final Object o, final Errors errors)
    {
        validateObject((T) o, errors);
    }
}
