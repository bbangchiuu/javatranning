/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.titlegame.worlds;

import dev.codenmore.titlegame.tiles.Tile;
import dev.codenmore.titlegame.utils.Utils;
import java.awt.Graphics;

/**
 *
 * @author BangNguyen
 */
public class World {
    
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    
    public World(String path){
        loadWorld(path);
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                getTile(x, y).render(g, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT); //xét vị trí của từng khối ảnh               
            }
        }
    }
    
    public Tile getTile(int x, int y){
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null){
            return Tile.dirTile;
        }
      
        return t;
    }
    
    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);    
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);
        
        
        
        tiles = new int[width][height];
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
                //System.out.println(tokens[(x + y * width) + 4]);
            }
        }
    }
}
