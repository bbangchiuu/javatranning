/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OanhBT1
 */
public class Client {

    final static int ServerPort = 1234;

    public static void main(String args[]) throws UnknownHostException, IOException {
        Scanner scn = new Scanner(System.in);

        // getting localhost ip 
        InetAddress ip = InetAddress.getByName("localhost");

        // establish the connection 
        Socket s = new Socket(ip, ServerPort);

        // obtaining input and out streams 
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());


        // sendMessage thread 
        Thread sendMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    // read the message to deliver. 
                    String msg = scn.nextLine();

                    try {
                        // write on the output stream 
                        dos.writeUTF(msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                    if ("logout".equals(msg)) {
                        try {
                            s.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                }
            }
        });

        // readMessage thread 
        Thread readMessage = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {
                        if (!s.isClosed()) {
                            String msg = dis.readUTF();
                            System.out.println(msg);
                        } else {
                            System.out.println("Bye ...");
                            break;
                        }
                    } catch (IOException e) {
                        //e.printStackTrace();
                    }
                }
            }
        });

        sendMessage.start();
        readMessage.start();

    }
}
