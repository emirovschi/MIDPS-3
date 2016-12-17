package com.emirovschi.midps3.converters;

public interface Populator<T, R>
{
    void populate(T source, R target);
}
