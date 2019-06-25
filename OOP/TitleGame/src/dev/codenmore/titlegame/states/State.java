/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.titlegame.states;

import dev.codenmore.titlegame.Game;
import java.awt.Graphics;

/**
 *
 * @author BangNguyen
 */
public abstract class State {
    
    private static State currentState = null;

    public static State getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(State currentState) {
        State.currentState = currentState;
    }
    
    //CLASS
    protected Game game;
    public State (Game game){
        this.game = game;
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
}
