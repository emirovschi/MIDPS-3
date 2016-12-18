package com.emirovschi.midps3.converters;

public interface Converter<T, R>
{
    R convert(T t);
}
