package com.emirovschi.midps3.images.converters;

import com.emirovschi.midps3.posts.models.PostModel;
import org.springframework.stereotype.Component;

@Component("imageConverter")
public class ImageConverter extends AbstractPostImageConverter
{
    @Override
    protected byte[] getImage(final PostModel post)
    {
        return post.getImage();
    }
}
