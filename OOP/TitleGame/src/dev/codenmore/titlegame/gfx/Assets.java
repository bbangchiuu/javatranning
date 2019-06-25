/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.titlegame.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author BangNguyen
 */
public class Assets {
    
    public static final int width = 41, height = 63;
    public static BufferedImage player, dirt, grass, stone, tree;
    
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        
        player = sheet.crop(0, 0, width, height);
        dirt = sheet.crop(width, 0, width, height);
        grass = sheet.crop(width * 2 + 12, 0, width + 9, height);
        stone = sheet.crop(width * 3 + 20, 0, width + 20, height);
        tree = sheet.crop(0, height, width, height);
        
    }
}
