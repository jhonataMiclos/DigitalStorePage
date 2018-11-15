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
public interface Launcher {
    public String getFileLocation();
    public double getRevisionNumber();
    public int getProductID();
    public void play();
    public void setFileLocation(String fileLocation);
    public void setRevisionNumber(double revisionNumber);
    public void setProductID(int productID);
    public boolean addToRepo();
}
