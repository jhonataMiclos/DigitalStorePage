/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Launchers;

import DBHandler.DBWriter;

/**
 *
 * @author jakec
 */
public class ProductLauncher implements Launcher {
    
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
        RunnerFactory rf = new RunnerFactory();
        this.rp = rf.getProductRunner(fileLocation); 
    }

    
    public void setRevisionNumber(double revisionNumber) {
        this.revisionNumber  = revisionNumber;
    }

    
    public void setProductID(int productID) {
        this.productID = productID;
    }
    
    
    public boolean addToRepo(){
        if(productID >= 0 && fileLocation.length() > 0){
            DBWriter w = new DBWriter();
            w.insertNewLauncher(fileLocation, productID);
            return true;
        } else {
            return false;
        }
    }
}
