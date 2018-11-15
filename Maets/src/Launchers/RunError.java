/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Launchers;

import javax.swing.JOptionPane;

/**
 *
 * @author jakec
 */
public class RunError implements RunProduct {

    public RunError() {
    }
    
    public void play(){
        JOptionPane.showMessageDialog(null, "Error: File format unsupported, please contact admins for help");
    }
    
}
