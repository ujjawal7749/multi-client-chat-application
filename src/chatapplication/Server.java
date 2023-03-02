/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author ujjaw
 */
class ServerSR {

    Hashtable<Socket, Receiver> client_list = new Hashtable();
    Hashtable<Socket, String> name_list = new Hashtable<>();
    Hashtable<String,String> client_table = new Hashtable<>();
    ServerSocket sv_socket;

    public ServerSR() {
        try {
            sv_socket = new ServerSocket(5000);
            Sender sd = new Sender();

            AcceptConnections conn = new AcceptConnections();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    class AcceptConnections extends Thread {

        public AcceptConnections() {
            start();
        }

        public void run() {
            while (true) {
                try {

                    Socket socket = sv_socket.accept();
                    HandleNewConnection new_connection_thread = new HandleNewConnection(socket);

                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
    }

    class HandleNewConnection extends Thread {

        Socket socket;

        public HandleNewConnection(Socket socket) {
            this.socket = socket;
            start();
        }

        public void run() {
            try {
                BufferedReader br
                        = new BufferedReader(
                                new InputStreamReader(
                                        socket.getInputStream()));

                String name = br.readLine();

                if (!client_list.containsKey(socket)) {
                    name_list.put(socket, name);
                    Receiver rv = new Receiver(socket);
                    client_list.put(socket, rv);
                    
                    client_table.put(adrport(socket), name);
                            
                    sendNameList(socket);
                    String alert = ("New connection;" + adrport(socket) + ";" + name_list.get(socket));
                    System.out.println(alert);
                    SenderThread sdx = new SenderThread(alert);
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

        public void sendNameList(Socket socket) {
            try {
                PrintStream pc = new PrintStream(socket.getOutputStream());
                String send_string="";
                for(Socket sc:name_list.keySet())
                {
                   send_string = send_string+adrport(sc) + ";" + name_list.get(sc)+"=";
                }
                send_string=send_string.substring(0,send_string.length()-1);
                //System.out.println("This "+send_string);
                pc.println(send_string);
            } catch (Exception e) {
                System.out.println(e.toString());

        }
    }
    }
    private String adrport(Socket socket) {
        String x = socket.getInetAddress() + "," + String.valueOf(socket.getPort());
        //System.out.println("Fuck "+x);
        return x;
    }

    class MirrorSend extends Thread {

        Socket socket;
        String msg;

        public MirrorSend(Socket socket, String msg) {
            this.socket = socket;
            this.msg = msg;
            start();
        }

        public void run() {
            SenderThread st = new SenderThread(socket.getInetAddress() + "," + String.valueOf(socket.getPort()) + " -- " + msg);
        }

    }

    class Sender extends Thread {

        public Sender() {
            start();
        }

        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                while (true) {
                    String msg = br.readLine();
                    SenderThread st = new SenderThread(sv_socket.getLocalSocketAddress() + "," + String.valueOf(sv_socket.getLocalPort()) + " -- " + msg);
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    class SenderThread extends Thread {

        String message;

        public SenderThread(String message) {
            this.message = message;
            start();
        }

        public void run() {
            for (Socket client_socket : client_list.keySet()) {
                try {
                    PrintStream ps
                            = new PrintStream(
                                    client_socket.getOutputStream());

                    ps.println(message);

                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
    }

    class Receiver extends Thread {

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

                while (true) {
                    if (client_list.containsKey(socket)) {
                        String rcv = br.readLine();
                        
                        String tp = rcv;
                        String header_string = adrport(socket);
                           
                        tp = client_table.get(header_string)+" -- "+tp;
                        
                        System.out.println(tp);
                        MirrorSend mirror_sender_thread = new MirrorSend(socket, rcv);
                    } else {
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSR sv = new ServerSR();
    }
}
