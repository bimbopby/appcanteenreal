/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Administrator
 */
public class ImageCon {
    public static Image resize (Image oriImg , int targetWidth ,int targetHeight ){
        Image resultImg =  oriImg.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        return resultImg;
    }
    
    public static byte [] tobyteArr(Image img , String type) throws IOException{
        BufferedImage bimg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bimg.createGraphics();
        g.drawImage(img, 0, 0,null);
        g.dispose();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bimg, type, baos);
        byte [] imgInByte = baos.toByteArray();
        return imgInByte;
        
    }
    
    public static Image createImgFromByteArray(byte [] data, String type) throws IOException{
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        BufferedImage bimg2 = ImageIO.read(bais);
         Image img = bimg2.getScaledInstance(bimg2.getWidth(), bimg2.getHeight(), Image.SCALE_SMOOTH);
         return img;
    }
}
