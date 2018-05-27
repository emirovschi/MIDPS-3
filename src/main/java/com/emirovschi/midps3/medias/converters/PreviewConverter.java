package com.emirovschi.midps3.medias.converters;

import com.emirovschi.midps3.posts.models.PostModel;
import org.springframework.stereotype.Component;

@Component("previewConverter")
public class PreviewConverter extends AbstractPostImageConverter
{
    @Override
    protected byte[] getMedia(final PostModel post)
    {
        return post.getPreview();
    }
}
