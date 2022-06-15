/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.toolsmanager2tex.utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Miguel
 */
public class ImageUtils {
    
    
    public static ImageIcon resizeImageIcon(String image, int desiredWidth, int desiredHeight) {
        int newHeight = 0;
        int newWidth = 0;
        BufferedImage originalBufferedImage = null;
        ImageIcon icon = null;

        try {
            originalBufferedImage = ImageIO.read(new URL("https://spdvilns.blob.core.windows.net/toolmanagerimages/"+ image));
            float aspectRatio = (float) originalBufferedImage.getWidth() / originalBufferedImage.getHeight();
            if (originalBufferedImage.getWidth() > originalBufferedImage.getHeight()) {
                newWidth = desiredWidth;
                newHeight = Math.round(desiredWidth / aspectRatio);
            } else {
                newHeight = desiredHeight;
                newWidth = Math.round(desiredHeight * aspectRatio);
            }
            BufferedImage resultingImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = resultingImage.createGraphics();
            graphics2D.drawImage(originalBufferedImage, 0, 0, newWidth, newHeight, null);
            graphics2D.dispose();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(resultingImage, Constants.DEFAULT_PROFILE_IMAGE_TYPE, baos);
            icon = new ImageIcon(baos.toByteArray());

            baos.close();

        } catch (IOException ex) {
            Logger.getLogger(ImageUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return icon;
    }
    
    public static ImageIcon resizeImageIcon2 (BufferedImage originalImage, int desiredWidth, int desiredHeight) {
        int newHeight = 0;    
        int newWidth = 0;
        float aspectRatio = (float)originalImage.getWidth() / originalImage.getHeight();
        if (originalImage.getWidth() > originalImage.getHeight()) {
            newWidth = desiredWidth;
            newHeight = Math.round( desiredWidth / aspectRatio);                
        }
        else {
            newHeight = desiredHeight;
            newWidth = Math.round(desiredHeight * aspectRatio);
        }
        Image resultingImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage outputImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        ImageIcon imageIcon = new ImageIcon(outputImage);
        return imageIcon;
    }
}
