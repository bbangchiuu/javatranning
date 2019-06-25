/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.titlegame.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 *
 * @author BangNguyen
 */

//lấy đường dẫn của ảnh
public class ImageLoader {
    
    public static BufferedImage loadImage(String path){
        //System.out.println("dev.codenmore.titlegame.gfx.ImageLoader.loadImage()");
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException ex) {
            
            ex.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
