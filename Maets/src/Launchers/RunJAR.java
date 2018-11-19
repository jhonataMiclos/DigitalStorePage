/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Launchers;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jakec
 */
public class RunJAR implements RunProduct {

    private String fileLocation;
    public RunJAR(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public void play() {
        try {
        Process proc = Runtime.getRuntime().exec("java -jar "+fileLocation);
        InputStream in = proc.getInputStream();
        InputStream err = proc.getErrorStream();
        } catch (IOException ex) {
            Logger.getLogger(RunJAR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
