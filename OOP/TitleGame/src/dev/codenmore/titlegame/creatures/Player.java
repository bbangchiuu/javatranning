/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.titlegame.creatures;

import dev.codenmore.titlegame.Game;
import dev.codenmore.titlegame.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author BangNguyen
 */
public class Player extends Creature{

    private Game game;
    public Player(Game game, float x, float y) {
        super(x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
        this.game = game;
    }

    @Override
    public void tick() {
//        if(game.getKeyManager().up){
//            y -= 3;
//        }
//        
//        if(game.getKeyManager().down){
//            y += 3;
//        }
//        
//        if(game.getKeyManager().left){
//            x -= 3;
//        }
//        
//        if(game.getKeyManager().right){
//            x += 3;
//        }

        getInput();
        move();
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;
        
        if(game.getKeyManager().up){
            yMove = -speed;
        }
        
        if(game.getKeyManager().down){
            yMove = speed;
        }
        
        if(game.getKeyManager().left){
            xMove = -speed;
        }
        
        if(game.getKeyManager().right){
            xMove = speed;
        }
    }
    
    @Override
    public void render(Graphics g) {
        
        g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
    }
    
}
