/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Launchers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author jakec
 */
public class RunTXT implements RunProduct {
    
    private String fileLocation;

    public RunTXT(String fileLocation) {
         this.fileLocation = fileLocation;
    }

    @Override
    public void play() {
        String input = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileLocation);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((input += bufferedReader.readLine()) != null) {
            }   

            // Always close files.
            bufferedReader.close(); 
            JOptionPane.showMessageDialog(null, input);
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileLocation + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileLocation + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
    
}
