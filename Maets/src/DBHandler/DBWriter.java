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

/**
 *
 * @author jakec
 */
public class DBWriter {
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
    
}
