/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreInfo.DBHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jakec
 */
public class DBConnector {
    
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static DBConnector instance = null;
    private String dbName = "maets";
    private boolean connectionFlag = false;

    public static synchronized DBConnector getInstance(){//Singleton stuff
        if(instance==null){
           instance = new DBConnector();
      }
      return instance;
  }
    
    public DBConnector(){
        connectDataBase();
        instance = this;
    }
    
    public void connectDataBase(){//Connects this instance to the actual database
        try{
        // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/"+dbName+"?"
                        + "user=root&password=");

        // Statements allow to issue SQL queries to the database
        statement = (Statement) connect.createStatement();
        connectionFlag = true;
        }
        catch(Exception e){
            connectionFlag = false;
            System.out.print("Error: "+e);
        }
    }
    
    public ResultSet getResultSet(String sqlStatement){
        if(!connectionFlag){
            connectDataBase();
        }
        try{
            resultSet = statement
                    .executeQuery(sqlStatement);
            return resultSet;
        }
        catch(SQLException e){
            System.out.print(e);
        }
        return resultSet;
    }
    
    Connection getConnect(){
        if(!connectionFlag){
            connectDataBase();
        }
        return connect;
    }
    
    void execute(PreparedStatement ps) throws Exception{//Executes a given statement
        if(!connectionFlag){
            connectDataBase();
        }
        ps.executeUpdate();
        connect.close();
        connectionFlag = false;
    }
    
    ResultSet execute(String sqlStatement){//Executes a given statement
        if(!connectionFlag)
            connectDataBase();
        ResultSet s = null;
        try {
            s =  statement.executeQuery(sqlStatement);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    void close() {
    
    }
}
