/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketdemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author admin
 */
public class Server extends Thread {
    private ServerSocket socketServer;
    
    public Server(int port) throws IOException {
        socketServer = new ServerSocket(port);
    }
    
    public void run() {
        while(true) {
            try {
                System.out.println("Client connected: " 
                        + socketServer.getLocalPort());
                Socket socket = socketServer.accept();
                
                DataInputStream input = 
                        new DataInputStream(socket.getInputStream());
                DataOutputStream out = 
                        new DataOutputStream(socket.getOutputStream());
               
                String helloFromClient = input.readUTF();
                System.out.println("Client: " + helloFromClient); 
                
                out.writeUTF("Hello from Server");
                
                socket.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            Thread server = new Server(6060);
            server.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
