package com.emirovschi.midps3.list.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.list.dto.ListDTO;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ListConverter<T, TDTO> implements Converter<List<T>, ListDTO<TDTO>>
{
    @Override
    public ListDTO<TDTO> convert(final List<T> list)
    {
        final ListDTO<TDTO> listDTO = new ListDTO<>();
        listDTO.setItems(list.stream().map(getItemConverter()::convert).collect(Collectors.toList()));
        return listDTO;
    }

    protected abstract Converter<T, TDTO> getItemConverter();
}