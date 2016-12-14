package com.emirovschi.midps3.images.impl;

import com.emirovschi.midps3.images.ImageFacade;
import com.emirovschi.midps3.images.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import static javax.imageio.ImageIO.read;
import static javax.imageio.ImageIO.write;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;

@Component
public class ImageFacadeImpl implements ImageFacade
{
    @Autowired
    private ImageService imageService;

    @Override
    public byte[] getPreview(final byte[] image, final String imageType) throws IOException
    {
        final BufferedImage original = read(new ByteArrayInputStream(image));
        final BufferedImage resized = imageService.getPreview(original, getType(imageType));

        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
        write(resized, getFormat(imageType), stream);
        return stream.toByteArray();
    }

    private int getType(final String imageType)
    {
        return imageType.equals(IMAGE_JPEG_VALUE) ? TYPE_INT_RGB : TYPE_INT_ARGB;
    }

    private String getFormat(final String imageType)
    {
        return imageType.replace("image/", "");
    }
}
