package com.invoice.vision.service.impl;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Component
public class CropImages {

    BufferedImage createImageFromBytes(byte[] imageData) {
        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
        try {
            return ImageIO.read(bais);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedImage cropImage(BufferedImage src, Integer width, Integer height) {
        BufferedImage dest = src.getSubimage(0, 0, width, height);
        return dest;
    }
}
