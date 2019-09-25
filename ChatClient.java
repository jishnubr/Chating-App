/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Student
 */
public class ChatClient {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Socket s= new Socket("localhost",6666);
            DataOutputStream DataOutputStream = new DataOutputStream(s.getOutputStream());;
            String Msg = "";
            String str = "";
            while(!Msg.equals("stop")&& !str.equals("stop") ){
                DataOutputStream = new DataOutputStream(s.getOutputStream());
                System.out.println("Enter Your Message");
                Msg = sc.next();
                DataOutputStream.writeUTF(Msg);
                DataOutputStream.flush();
                //Read Data from server
                if(!Msg.equals("stop")){
                    System.out.println("Waiting for Server");
                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    str = (String)dis.readUTF();
                    System.out.println("Server says = "+str);
                }
            }
            DataOutputStream.close();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
