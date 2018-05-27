package com.emirovschi.midps3.medias.converters;

import com.emirovschi.midps3.posts.models.PostModel;
import org.springframework.stereotype.Component;

@Component("mediaConverter")
public class MediaConverter extends AbstractPostImageConverter
{
    @Override
    protected byte[] getMedia(final PostModel post)
    {
        return post.getMedia();
    }
}
