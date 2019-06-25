/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.io.*;
import java.util.*;
import java.net.*;

/**
 *
 * @author OanhBT1
 */
public class ClientHandler implements Runnable {

    Scanner scn = new Scanner(System.in);
    private String name;
    final DataInputStream dis;
    final DataOutputStream dos;
    Socket s;
    boolean isloggedin;

    // constructor 
    public ClientHandler(Socket s, String name,
            DataInputStream dis, DataOutputStream dos) {
        this.dis = dis;
        this.dos = dos;
        this.name = name;
        this.s = s;
        this.isloggedin = true;
    }

    @Override
    public void run() {

        String received;
        while (true) {
            try {
                // receive the string 
                received = dis.readUTF();

                //System.out.println(received);
                if (received.equals("logout")) {
                    this.isloggedin = false;
                    this.s.close();
                    System.out.println(name + ": logout");
                    break;
                } else if (received.contains(":")) {
                    StringTokenizer st = new StringTokenizer(received, ":");
                    String username = st.nextToken();
                    String pass = st.nextToken();
                    System.out.println("username :" + username);
                    for (ClientHandler mc : Server.ar) {
                        if (mc.name.equals(this.name) && mc.isloggedin == true) {
                            //Server.ar.removeElement(mc);
                            mc.name = username;
                            //Server.ar.add(mc);
                            System.out.println("username :" + mc.s);
                        }
                    }
                }

                // break the string into message and recipient part 
                if (received.contains("#")) {
                    StringTokenizer st = new StringTokenizer(received, "#");
                    String MsgToSend = st.nextToken();
                    String recipient = st.nextToken();

                    // search for the recipient in the connected devices list. 
                    // ar is the vector storing client of active users 
                    for (ClientHandler mc : Server.ar) {
                        // if the recipient is found, write on its 
                        // output stream 
                        if (mc.name.equals(recipient) && mc.isloggedin == true) {
                            mc.dos.writeUTF(this.name + " : " + MsgToSend);
                            break;
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            // closing resources 
            this.dis.close();
            this.dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
