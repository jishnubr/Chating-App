/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Student
 */
public class ChatServer {
    public static void main(String[] args) {
        try {
                ServerSocket ServerSocket = new ServerSocket(6666);
                Scanner sc = new Scanner(System.in);
                System.out.println("Server Running");
                Socket s = ServerSocket.accept();
                String str = "";
                String Msg = "";
                while(!Msg.equals("stop")&& !str.equals("stop") ){
                    System.out.println("Waiting for client");
                    DataInputStream dis= new DataInputStream(s.getInputStream());
                    str = (String)dis.readUTF();
                    System.out.println("Client says = "+str);
                    if(!str.equals("stop")){
                        //Sending data to client
                        DataOutputStream DataOutputStream = new DataOutputStream(s.getOutputStream());
                        System.out.println("Enter Your Message");
                        Msg = sc.next();
                        DataOutputStream.writeUTF(Msg);
                        DataOutputStream.flush();
                }
                
            }
            ServerSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
