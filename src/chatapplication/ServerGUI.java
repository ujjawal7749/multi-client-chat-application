/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package chatapplication;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ujjaw
 */
public class ServerGUI extends javax.swing.JFrame {

    TripleDES tdes = new TripleDES();
    
    ServerSR server;

    /**
     * Creates new form ServerGUI
     */
    public ServerGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setText("5000");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Port -");

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IP,Port", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Send");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(270, 270, 270))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                            .addComponent(jTextField2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            int port = Integer.parseInt(jTextField1.getText());
            server = new ServerSR(port);
            jButton1.setEnabled(false);
            jTextField1.setEnabled(false);
        } catch (Exception e) {
            Commons.dialog("Invalid port entered");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        btclick();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btclick();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void btclick() {
        String msg = jTextField2.getText();
//        String linebroken[] = msg.split("\n");
//        for (String line : linebroken) {
//            server.externalCallSender(line);
//        }
        server.externalCallSender(msg);
        jTextField2.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    class ServerSR {

        Hashtable<Socket, Receiver> client_list = new Hashtable();
        Hashtable<Socket, String> name_list = new Hashtable<>();
        Hashtable<String, String> client_table = new Hashtable<>();
        ServerSocket sv_socket;

        public ServerSR(int port) {
            try {
                sv_socket = new ServerSocket(port);
                Sender sd = new Sender();

                AcceptConnections conn = new AcceptConnections();

            } catch (Exception e) {
                System.out.println(e.toString());
                Commons.dialog("Port Error", "The port " + String.valueOf(port) + " is already in use by another application");
            }
        }

        class AcceptConnections extends Thread {

            public AcceptConnections() {
                start();
            }

            public void run() {
                messageadd("Server is Running");
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

                    String name = tdes.decrypt(br.readLine());

                    if (!client_list.containsKey(socket)) {
                        name_list.put(socket, name);
                        Receiver rv = new Receiver(socket);
                        client_list.put(socket, rv);

                        client_table.put(adrport(socket), name);

                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.addRow(new Object[]{adrport(socket), name});

                        sendNameList(socket);
                        String alert = ("New connection;" + adrport(socket) + ";" + name_list.get(socket));
                        messageadd(alert);
                        SenderThread sdx = new SenderThread(alert);
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }

            public void sendNameList(Socket socket) {
                try {
                    PrintStream pc = new PrintStream(socket.getOutputStream());
                    String send_string = "";
                    for (Socket sc : name_list.keySet()) {
                        send_string = send_string + adrport(sc) + ";" + name_list.get(sc) + "=";
                    }
                    send_string = tdes.encrypt(send_string.substring(0, send_string.length() - 1));
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

        public void externalCallSender(String message) {
            String send_string = sv_socket.getLocalSocketAddress() + "," + String.valueOf(sv_socket.getLocalPort()) + " -- " + message;
            messageadd("Server >> " + message);
            SenderThread st = new SenderThread(send_string);
        }

        class SenderThread extends Thread {

            String message;

            public SenderThread(String message) {
                this.message = message;
                start();
            }

            public void run() {
                for (Socket client_socket : client_list.keySet()) {
                    if(client_socket.isClosed()){System.out.println("Closed");}
                    try {
                        PrintStream ps
                                = new PrintStream(
                                        client_socket.getOutputStream());

                        ps.println(tdes.encrypt(message));

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
                            String rcv = tdes.decrypt(br.readLine());

                            String tp = rcv;
                            String header_string = adrport(socket);

                            tp = client_table.get(header_string) + " -- " + tp;

                            messageadd(tp);
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

        public void messageadd(String str) {
            jTextArea1.append(str + "\n");
        }
    }

}