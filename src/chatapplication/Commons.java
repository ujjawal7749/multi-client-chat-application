/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapplication;

import javax.swing.JOptionPane;

/**
 *
 * @author ujjaw
 */
public class Commons {
    public static void dialog(String title,String message)
    {
        JOptionPane.showMessageDialog(null, message,
                                   title, JOptionPane.ERROR_MESSAGE);
    }
    
    public static void dialog(String message)
    {
        JOptionPane.showMessageDialog(null, message,
                                   "Error", JOptionPane.ERROR_MESSAGE);
    }
}
