package com.emirovschi.midps3.posts.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.posts.dto.PageDTO;
import org.springframework.data.domain.Page;

import java.util.stream.Collectors;

public abstract class PageConverter<T, TDTO> implements Converter<Page<T>, PageDTO<TDTO>>
{
    @Override
    public PageDTO<TDTO> convert(final Page<T> page)
    {
        final PageDTO<TDTO> pageDTO = new PageDTO<>();
        pageDTO.setCurrentPage(page.getNumber());
        pageDTO.setPageSize(page.getSize());
        pageDTO.setTotalPage(page.getTotalPages());
        pageDTO.setTotalItems(page.getTotalElements());
        pageDTO.setItems(page.getContent().stream().map(getItemConverter()::convert).collect(Collectors.toList()));
        return pageDTO;
    }

    protected abstract Converter<T, TDTO> getItemConverter();
}
