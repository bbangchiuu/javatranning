/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.titlegame.states;

import dev.codenmore.titlegame.Game;
import dev.codenmore.titlegame.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author BangNguyen
 */
public class MenuState extends State{
    
    public MenuState(Game game){
        super(game);
    }
    
    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.dirt, 0, 0, null);
    }
}
