/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.titlegame.states;

import dev.codenmore.titlegame.Game;
import dev.codenmore.titlegame.creatures.Player;
import dev.codenmore.titlegame.gfx.Assets;
import dev.codenmore.titlegame.tiles.Tile;
import dev.codenmore.titlegame.worlds.World;
import java.awt.Graphics;

/**
 *
 * @author BangNguyen
 */
public class GameState extends State {

    private Player player;
    private World world;
    
    public GameState(Game game){
        super(game);
        player = new Player(game, 100, 100);//hình ảnh player và vị trí
        world = new World("res/worlds/world1.txt");
    }
    
    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
        //Tile.tiles[0].render(g, 0, 0);
    }
    
}
