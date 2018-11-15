/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHandler;

import java.util.Date;

/**
 *
 * @author jakec
 */
public interface RepositoryWriter {
    public boolean insertUser(String username, String password, int type);
    public boolean promoteUserToAdmin(String username);
    public boolean RemoveGame(int gameID);
    public boolean insertLogoutTime(String username, Date dateTime);
    public boolean insertLoginTime(String username, Date dateTime);
    public boolean insertNewGame(int productID, String name, double price, int ageRating, String description,String minimumSpecs, String genres, int publisherID);
    public boolean insertNewMovie(int productID, String name, double price, int ageRating, String description,int runTime, String genres, int publisherID);
    public boolean insertIntoCart(String username, int productID);
    public boolean insertNewLauncher(String fileLocation, int productID);
    public boolean updateLauncher(String fileLocation, int productID);
    public boolean insertHistory(String username,int ProductID);
    public boolean insertUser(String username, String password, int userType, String publisherName);
    public boolean clearCart(String username);
}
