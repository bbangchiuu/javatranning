/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.titlegame.utils;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author BangNguyen
 */
public class Utils {
    
    public static String loadFileAsString(String path){
        StringBuilder builder = new StringBuilder();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
               builder.append(line + "\n");
                //System.out.println(line);
            }
            //System.out.println(builder);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return builder.toString();
    }
    
    public static int parseInt(String number){
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
