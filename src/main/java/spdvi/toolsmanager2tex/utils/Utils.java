/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spdvi.toolsmanager2tex.utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author lluis
 */
public class Utils {
    public static void showHidePassword(javax.swing.JPasswordField pwsField, boolean show) {
        if (show) {
            pwsField.setEchoChar((char) 0);    
        } else {
            pwsField.setEchoChar((char) '*');
        }
    }
    
    public static void errorMessage(String message)
    {
        System.err.println(message);
                JOptionPane.showMessageDialog(null,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
    
    public static void infoMessage(String message)
    {
        System.err.println(message);
                JOptionPane.showMessageDialog(null,
                message,
                "Info",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void warningMessage(String message)
    {
        System.err.println(message);
                JOptionPane.showMessageDialog(null,
                message,
                "Warning",
                JOptionPane.WARNING_MESSAGE);
    }
    

}
