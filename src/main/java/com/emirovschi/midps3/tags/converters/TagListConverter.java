package com.emirovschi.midps3.tags.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.tags.dto.TagDTO;
import com.emirovschi.midps3.tags.models.TagModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagListConverter extends ListConverter<TagModel, TagDTO>
{
    @Autowired
    private Converter<TagModel, TagDTO> tagConverter;

    @Override
    protected Converter<TagModel, TagDTO> getItemConverter()
    {
        return tagConverter;
    }
}
