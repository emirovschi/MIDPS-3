package com.emirovschi.midps3.posts.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class PostConfiguration
{
    @Bean("allowedContentTypes")
    public Set<String> getAllowedContentTypes()
    {
        final Set<String> allowedContentTypes = new HashSet<>();
        allowedContentTypes.add(MediaType.IMAGE_JPEG_VALUE);
        allowedContentTypes.add(MediaType.IMAGE_PNG_VALUE);
        return allowedContentTypes;
    }
}
