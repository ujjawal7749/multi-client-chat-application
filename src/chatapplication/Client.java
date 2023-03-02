/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.Hashtable;

/**
 *
 * @author ujjaw
 */
class ClientSR {

    Hashtable<String, String> client_table = new Hashtable<>();

    public ClientSR() {
        try {
            Socket socket = new Socket("localhost", 5000);
            Receiver rv = new Receiver(socket);
            Sender sd = new Sender(socket);
        } catch (Exception e) {
            System.out.println("Error Spot 1");
        }
    }

    private class Sender extends Thread {

        Socket socket;

        public Sender(Socket socket) {
            this.socket = socket;
            start();
        }

        public void run() {
            try {

                PrintStream ps
                        = new PrintStream(
                                socket.getOutputStream());

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                ps.println(br.readLine());

                while (true) {
                    ps.println(br.readLine());
                }

            } catch (Exception e) {
                System.out.println("Error Spot 2");
            }
        }
    }

    private class Receiver extends Thread {

        Socket socket;

        public Receiver(Socket socket) {
            this.socket = socket;
            start();
        }

        public void run() {
            try {
                BufferedReader br
                        = new BufferedReader(
                                new InputStreamReader(
                                        socket.getInputStream()));
                
                String rc = br.readLine();
                String clients[] = rc.split("=");
                for (String s : clients) {
                    String[] sliced = slicer(s);
                    //System.out.println(sliced[0]);
                    if (!client_table.containsKey(sliced[0])) {
                        client_table.put(sliced[0], sliced[1]);
                        System.out.println("Added at Init - " + sliced[0] + " " + sliced[1]);
                    }
                }

                while (true) {
                    String rcv = br.readLine();
                    if (rcv.startsWith("New connection;")) {
                        String[] sliced = slicer(rcv.substring(15));
                        //System.out.println(sliced[0]);
                        if (!client_table.containsKey(sliced[0])) {
                            client_table.put(sliced[0], sliced[1]);
                            System.out.println("Added on New Connection " + sliced[0] + " " + sliced[1]);
                            //System.out.println(rcv.substring(15));
                        }
                    } else {
                        String tp = rcv;
                        int space = tp.indexOf(" ", 0);
                        String header_string = tp.substring(0, space);
                        if (header_string.startsWith("0.0.0.0/0.0.0.0")) {
                            tp = tp.replace(header_string, "Server >>");
                            tp = tp.replaceFirst(" -- ", " ");
                        } else {
                            tp = tp.replace(header_string, client_table.get(header_string));
                        }

                        System.out.println(tp);
                    }
                }

            } catch (Exception e) {
                System.out.println("Error Spot 3");
            }
        }

        public String[] slicer(String rcv) {
            return rcv.split(";");
        }

    }
}

public class Client {

    public static void main(String[] args) throws Exception {
        ClientSR clsr = new ClientSR();
    }
}
