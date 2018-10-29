/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Launchers;

/**
 *
 * @author jakec
 */
public class Launcher {
    
    private String fileLocation;
    private int productID;
    private double revisionNumber;
    private RunProduct rp;

    
    public String getFileLocation() {
        return fileLocation;
    }

    
    public double getRevisionNumber() {
        return revisionNumber;
    }

    
    public int getProductID() {
        return productID;
    }

    
    public void play() {
        rp.play();
    }

    
    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
        this.rp = RunnerFactory.getProductRunner(fileLocation); 
    }

    
    public void setRevisionNumber(double revisionNumber) {
        this.revisionNumber  = revisionNumber;
    }

    
    public void setProductID(int productID) {
        this.productID = productID;
    }
}
