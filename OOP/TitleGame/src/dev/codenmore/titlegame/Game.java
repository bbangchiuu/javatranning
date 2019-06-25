/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.titlegame;

import dev.codenmore.titlegame.gfx.ImageLoader;
import dev.codenmore.titlegame.display.Display;
import dev.codenmore.titlegame.gfx.Assets;
import dev.codenmore.titlegame.gfx.SpriteSheet;
import dev.codenmore.titlegame.input.KeyManager;
import dev.codenmore.titlegame.states.GameState;
import dev.codenmore.titlegame.states.MenuState;
import dev.codenmore.titlegame.states.State;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BangNguyen
 */
public class Game implements Runnable{
    
    private Display display;
    private Thread thread;
    
    private boolean running = false;
    private int width, height;
    private String title;
    
    private BufferStrategy bs;
    private Graphics g;
    
    private BufferedImage testImage;
    private SpriteSheet sheet;
    
    //States
    private State gameState;
    private State menuState;
    
    //Input
    private KeyManager keyManager;
    
    public Game(String title, int width, int height)
    {
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
    }

    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);

        Assets.init();
        
        gameState = new GameState(this);
        //menuState = new MenuState(this);
        State.setCurrentState(gameState);
    }

    private void tick(){
        keyManager.tick();
        
        if(State.getCurrentState() != null){
            State.getCurrentState().tick();
        }
    }
    
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
       
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        
        g = bs.getDrawGraphics();
        
        //Clear Screen 
        g.clearRect(0, 0, width, height);
        
        //Drawm here!
        if(State.getCurrentState() != null){
            State.getCurrentState().render(g);
            //gameState.render(g);
        }
       
        
        //End Drawing!
        bs.show();
        g.dispose();
    }
    
    @Override
    public void run() {
        init();
        
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        long ticks = 0;
        
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            
            timer += now- lastTime;
            lastTime = now;
            
            if(delta >= 1){
                //System.out.println(delta);
                tick();
                render();
                ticks++;
                delta--;
            }
            
            if(timer > 1000000000){
                //System.out.println("Tick and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }
    
    //start
    public synchronized void start(){
        if(running){
            return;
        };
        
        running = true;
        thread = new Thread(this);
        thread.start(); // nó sẽ chạy run()
      
    }
    
    public synchronized void stop(){
        if(!running){
            return;
        };
        
        running = false;
        
        try {
            thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
