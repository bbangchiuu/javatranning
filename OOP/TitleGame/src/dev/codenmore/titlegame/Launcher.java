/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.titlegame;

import dev.codenmore.titlegame.display.Display;

/**
 *
 * @author BangNguyen
 */
public class Launcher {
    public static void main(String[] args) {

        Game game = new Game("Title Game", 900, 600);
        game.start();
    }
}
