/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;



/**
 *
 * @author jakec
 */
public class DBQueryParser implements RepositoryAccess {
    private String dbName = "maets";
    private PreparedStatement preparedStatement;
    private Connection c;
    
    
    public DBQueryParser(){
        DBConnector.getInstance().connectDataBase();
    }
    
  @Override
  public JSONArray getAllGames(){
      try {
        JSONArray array = new JSONArray();
        ResultSet resultSet = DBConnector.getInstance().execute("select * from "+dbName+".gamesStoreInfo");
        while(resultSet.next()){
            JSONObject gameJSON = new JSONObject();
            gameJSON.put("productID", resultSet.getInt("productID"));
            gameJSON.put("name", resultSet.getString("name"));
            gameJSON.put("price", resultSet.getDouble("price"));
            gameJSON.put("ageRating", resultSet.getInt("ageRating"));
            gameJSON.put("description", resultSet.getString("description"));
            gameJSON.put("minimumSpecs", resultSet.getString("minimumSpecs"));
            gameJSON.put("genre", resultSet.getString("genres"));
            gameJSON.put("publisherID", resultSet.getInt("publisherID"));
            array.put(gameJSON);
        }
        return array;
    }
    catch(Exception e){
        System.out.println("Error retrieving store info: "+e.toString());
        return new JSONArray();
    }
  }
  
   @Override
    public JSONArray getAllMovies(){
        try {
          JSONArray array = new JSONArray();
          ResultSet resultSet = DBConnector.getInstance().execute("select * from "+dbName+".movieStoreInfo");
          while(resultSet.next()){
              JSONObject movieJSON = new JSONObject();
              movieJSON.put("productID", resultSet.getInt("productID"));
              movieJSON.put("name", resultSet.getString("name"));
              movieJSON.put("price", resultSet.getDouble("price"));
              movieJSON.put("ageRating", resultSet.getInt("ageRating"));
              movieJSON.put("description", resultSet.getString("description"));
              movieJSON.put("runtime", resultSet.getInt("runtime"));
              movieJSON.put("genre", resultSet.getString("genres"));
              movieJSON.put("publisherID", resultSet.getInt("publisherID"));
              array.put(movieJSON);
          }
          return array;
      }
      catch(Exception e){
          System.out.println("Error retrieving store info: "+e.toString());
          return new JSONArray();
      }
    }
    
    @Override
    public JSONArray getAllUserTypes(){
        try {
          JSONArray array = new JSONArray();
          ResultSet resultSet = DBConnector.getInstance().execute("select * from "+dbName+".userType");
          while(resultSet.next()){
              JSONObject userTypeJSON = new JSONObject();
              userTypeJSON.put("ID", resultSet.getInt("ID"));
              userTypeJSON.put("type", resultSet.getString("type"));
              array.put(userTypeJSON);
          }
          return array;
      }
      catch(Exception e){
          System.out.println("Error retrieving user type info: "+e.toString());
          return new JSONArray();
      }
    }
    
    
    
    @Override
    public JSONObject getLoginInfo(String userName){
        try {
            JSONObject obj = new JSONObject();
            ResultSet resultSet = DBConnector.getInstance().execute("select * from "+dbName+".userlogin where userName = '" + userName+"'");
            if(resultSet.next()){
                obj.put("userName", resultSet.getString("userName"));
                obj.put("password", resultSet.getString("password"));
                obj.put("typeID", resultSet.getInt("typeID"));
            }
            
            return obj;
        }
        catch(Exception e){
          System.out.println("Error retrieving user Login: "+e.toString());
          return new JSONObject();
      }
    }

    @Override
    public JSONArray getAllUsers() {
        try {
          JSONArray array = new JSONArray();
          ResultSet resultSet = DBConnector.getInstance().execute("select * from "+dbName+".userlogin");
          while(resultSet.next()){
              JSONObject userTypeJSON = new JSONObject();
              userTypeJSON.put("userName", resultSet.getString("userName"));
              userTypeJSON.put("password", resultSet.getString("password"));
              userTypeJSON.put("typeID", resultSet.getString("typeID"));
              array.put(userTypeJSON);
          }
          return array;
      }
      catch(Exception e){
          System.out.println("Error retrieving user login info: "+e.toString());
          return new JSONArray();
      }
    }
}
