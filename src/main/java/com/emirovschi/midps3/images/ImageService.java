package com.emirovschi.midps3.images;

import java.awt.Image;
import java.awt.image.BufferedImage;

public interface ImageService
{
    BufferedImage getPreview(final BufferedImage image, final int type);
}