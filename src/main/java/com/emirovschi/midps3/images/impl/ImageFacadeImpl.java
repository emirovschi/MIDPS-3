package com.emirovschi.midps3.images.impl;

import com.emirovschi.midps3.images.ImageFacade;
import com.emirovschi.midps3.images.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import static javax.imageio.ImageIO.*;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;

@Component
public class ImageFacadeImpl implements ImageFacade
{
    @Autowired
    private ImageService imageService;

    @Override
    public byte[] getPreview(final byte[] image, final String imageType) throws IOException
    {
        final int type = imageType.equals(IMAGE_JPEG_VALUE) ? TYPE_INT_RGB : TYPE_INT_ARGB;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        write(imageService.getPreview(read(new ByteArrayInputStream(image)), type), imageType, stream);
        return stream.toByteArray();
    }
}
