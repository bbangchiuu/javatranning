/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketdemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author admin
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket(InetAddress.getByName("localhost"), 6060);
            DataInputStream input = 
                        new DataInputStream(client.getInputStream());
            
            DataOutputStream out = 
                        new DataOutputStream(client.getOutputStream());
            out.writeUTF("xin chao ..");
            
            String s = input.readUTF();
            System.out.println("Server: " + s);
            
            client.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
