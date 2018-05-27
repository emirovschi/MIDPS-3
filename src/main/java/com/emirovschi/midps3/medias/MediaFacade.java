package com.emirovschi.midps3.medias;

import com.emirovschi.midps3.posts.models.PostModel;

public interface MediaFacade
{
    int getWidth(PostModel post);

    int getHeight(PostModel post);
}
