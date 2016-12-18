package com.emirovschi.midps3.images.converters;

import com.emirovschi.midps3.posts.models.PostModel;
import org.springframework.stereotype.Component;

import java.sql.Blob;

@Component("previewConverter")
public class PreviewConverter extends AbstractPostImageConverter
{
    @Override
    protected Blob getImage(final PostModel post)
    {
        return post.getPreview();
    }
}
