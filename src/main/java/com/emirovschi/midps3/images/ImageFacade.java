package com.emirovschi.midps3.images;

import java.io.IOException;

public interface ImageFacade
{
    byte[] getPreview(byte[] image, String imageType) throws IOException;
}
