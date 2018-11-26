/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**0
 *
 * @author jakec
 */
public class DBWriter implements RepositoryWriter{
     private String dbName = "maets";
    private PreparedStatement preparedStatement;
    private Connection c;
    
    
    public DBWriter(){
        DBConnector.getInstance().connectDataBase();
    }
    
    
    public boolean insertUser(String username, String password, int type){
         try {
             String sql = "Insert into  "+dbName+".userlogin (userName, password, typeID) values (? , ?, ?)";
             
             PreparedStatement preparedStatement = DBConnector.getInstance().getPreparedStatement(sql);
             
             preparedStatement.setString(1, username);
             preparedStatement.setString(2, password);
             preparedStatement.setInt(3, type);
             
             int rowsAffected = preparedStatement.executeUpdate();
             return true;
         } catch (SQLException ex) {
             Logger.getLogger(DBWriter.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
    }
    
    public boolean promoteUserToAdmin(String username){
         try {
             String sql = "UPDATE "+dbName+".userlogin SET typeID = 3 WHERE userName = ?";
             
             PreparedStatement preparedStatement = DBConnector.getInstance().getPreparedStatement(sql);
             
             preparedStatement.setString(1, username);
             
             int rowsAffected = preparedStatement.executeUpdate();
             return true;
         } catch (SQLException ex) {
             Logger.getLogger(DBWriter.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
    }
    public boolean RemoveGame(int gameID){
        try{
            String sql = "DELETE from  "+dbName+".gamesstoreinfo WHERE productID = ?";
            String sql2 = "DELETE from  "+dbName+".moviestoreinfo WHERE productID = ?";
            PreparedStatement preparedStatement = DBConnector.getInstance().getPreparedStatement(sql);
            PreparedStatement preparedStatement2 = DBConnector.getInstance().getPreparedStatement(sql2);
             
            preparedStatement.setInt(1, gameID);
            preparedStatement2.setInt(1, gameID);
            int rowsAffected = preparedStatement.executeUpdate();
            rowsAffected = preparedStatement2.executeUpdate();
            return true;
        } catch (SQLException ex) {
             Logger.getLogger(DBWriter.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
    }
    public boolean insertLogoutTime(String username, Date dateTime)
    {
        
        try {
             String sql = "UPDATE "+dbName+".sessionrecords SET LogoutTime = ? WHERE userName = ? AND LogoutTime IS NULL";
             Timestamp dateTimeStr = new Timestamp(dateTime.getTime());
             PreparedStatement preparedStatement = DBConnector.getInstance().getPreparedStatement(sql);
             
             preparedStatement.setTimestamp(1, dateTimeStr);
             preparedStatement.setString(2, username);
             
             preparedStatement.executeUpdate();
             return true;
         } catch (SQLException ex) {
             Logger.getLogger(DBWriter.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
    }
    public boolean insertLoginTime(String username, Date dateTime)
    {
        try {
             String sql = "Insert into  "+dbName+".sessionrecords (userName, loginTime) values (? , ?)";
             Timestamp dateTimeStr = new Timestamp(dateTime.getTime());
             PreparedStatement preparedStatement = DBConnector.getInstance().getPreparedStatement(sql);
             
             preparedStatement.setString(1, username);
             preparedStatement.setTimestamp(2, dateTimeStr);
             
             preparedStatement.executeUpdate();
             return true;
         } catch (SQLException ex) {
             Logger.getLogger(DBWriter.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
    }
    
    public boolean insertNewGame(int productID, String name, double price, int ageRating, String description,String minimumSpecs, String genres, int publisherID)
    {
        try {
             String sql = "Insert into  "+dbName+".gamesstoreinfo (name,price,ageRating,description,minimumSpecs,genres,publisherID, productID) values (?,? , ?,?,?,?,?,?)";
             PreparedStatement preparedStatement = DBConnector.getInstance().getPreparedStatement(sql);
             
             preparedStatement.setString(1, name);
             preparedStatement.setDouble(2, price);
             preparedStatement.setInt(3, ageRating);
             preparedStatement.setString(4, description);
             preparedStatement.setString(5, minimumSpecs);
             preparedStatement.setString(6, genres);
             preparedStatement.setInt(7, publisherID);
             preparedStatement.setInt(8, productID);
             
             preparedStatement.executeUpdate();
             return true;
         } catch (SQLException ex) {
             Logger.getLogger(DBWriter.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
    }
    
    
    public boolean insertNewMovie(int productID, String name, double price, int ageRating, String description,int runTime, String genres, int publisherID)
    {
        try {
             String sql = "Insert into  "+dbName+".moviestoreinfo (name,price,ageRating,description,runTime,genres,publisherID, productID) values (? , ?,?,?,?,?,?,?)";
             PreparedStatement preparedStatement = DBConnector.getInstance().getPreparedStatement(sql);
             
             preparedStatement.setString(1, name);
             preparedStatement.setDouble(2, price);
             preparedStatement.setInt(3, ageRating);
             preparedStatement.setString(4, description);
             preparedStatement.setInt(5, runTime);
             preparedStatement.setString(6, genres);
             preparedStatement.setInt(7, publisherID);
             preparedStatement.setInt(8, productID);
             
             preparedStatement.executeUpdate();
             return true;
         } catch (SQLException ex) {
             
           Logger.getLogger(DBWriter.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
    }
        
    public boolean insertIntoCart(String username, int productID){
         try {
             String sql = "Insert into  "+dbName+".carts (userName, productID ) values (? , ?)";
             
             PreparedStatement preparedStatement = DBConnector.getInstance().getPreparedStatement(sql);
             
             preparedStatement.setString(1, username);
             preparedStatement.setInt(2, productID);
             
             int rowsAffected = preparedStatement.executeUpdate();
             return true;
            } catch (SQLException ex) {
             Logger.getLogger(DBWriter.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println(ex.toString());
             return false;
         }
    }
    
    
    public boolean insertNewLauncher(String fileLocation, int productID)
    {
        try {
             String sql = "Insert into  "+dbName+".gamelaunchers (productID, fileLocation) values (? , ?)";
             PreparedStatement preparedStatement = DBConnector.getInstance().getPreparedStatement(sql);
             
             
             preparedStatement.setInt(1, productID);
             preparedStatement.setString(2, fileLocation);
             
                 preparedStatement.executeUpdate();
             return true;
         } catch (SQLException ex) {
             Logger.getLogger(DBWriter.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
    }
    
    
    public boolean updateLauncher(String fileLocation, int productID)
    {
        try {
             String sql = "Update "+dbName+".gameslaunchers set revision = revision + 1 AND fileLocation = ? where productID = ?";
             PreparedStatement preparedStatement = DBConnector.getInstance().getPreparedStatement(sql);
             
          
             preparedStatement.setString(1, fileLocation);
             preparedStatement.setInt(2, productID);
             
             preparedStatement.executeUpdate();

             return true;
         } catch (SQLException ex) {
             Logger.getLogger(DBWriter.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
    }
    
    public boolean insertHistory(String username,int ProductID){
         try {
             String sql = "Insert into  "+dbName+".history (userName,productID) values (? , ?)";
             
             PreparedStatement preparedStatement = DBConnector.getInstance().getPreparedStatement(sql);
             preparedStatement.setString(1, username);
             preparedStatement.setInt(2, ProductID);
             
             int rowsAffected = preparedStatement.executeUpdate();
            return true;
         } catch (SQLException ex) {
             Logger.getLogger(DBWriter.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
    }
    public boolean insertUser(String username, String password, int userType, String publisherName) {
        insertUser(username, password, userType);
        try {
             String sql = "Insert into  "+dbName+".publisherInfo (userName, publisherName) values (? , ?)";
             
             PreparedStatement preparedStatement = DBConnector.getInstance().getPreparedStatement(sql);
             
             preparedStatement.setString(1, username);
             preparedStatement.setString(2, publisherName);
              int rowsAffected = preparedStatement.executeUpdate();
            return true;
         } catch (SQLException ex) {
             Logger.getLogger(DBWriter.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
    }
    
    public boolean clearCart(String username) {
        try {
             String sql = "DELETE from  "+dbName+".carts WHERE username = ?";             
             PreparedStatement preparedStatement = DBConnector.getInstance().getPreparedStatement(sql);
             
             preparedStatement.setString(1, username);
             
             int rowsAffected = preparedStatement.executeUpdate();
             return true;
         } catch (SQLException ex) {
             Logger.getLogger(DBWriter.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
    }
}
