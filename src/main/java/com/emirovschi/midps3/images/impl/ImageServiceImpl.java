package com.emirovschi.midps3.images.impl;

import com.emirovschi.midps3.images.ImageService;
import org.springframework.stereotype.Service;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

@Service
public class ImageServiceImpl implements ImageService
{
    private final static int PREVIEW_WIDTH = 600;
    private final static int ORIGINAL_WIDTH = 600;

    @Override
    public BufferedImage getPreview(final BufferedImage image, final int type)
    {
        return resize(image, type, PREVIEW_WIDTH, image.getHeight() * PREVIEW_WIDTH / image.getWidth());
    }

    private BufferedImage resize(final Image image, final int type, final int scaledWidth, final int scaledHeight)
    {
        BufferedImage resizedImage = new BufferedImage(scaledWidth, scaledHeight, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(image, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        return resizedImage;
    }
}
