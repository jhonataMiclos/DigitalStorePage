/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
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
    
    @Override
    public JSONArray getAllUsersData(){
        
        try {
          JSONArray array = new JSONArray();
          ResultSet resultSet = DBConnector.getInstance().execute("select * from "+dbName+".sessionrecords where LogoutTime IS NOT NULL");
          while(resultSet.next()){
              JSONObject userTypeJSON = new JSONObject();
              userTypeJSON.put("userName", resultSet.getString("userName"));
              userTypeJSON.put("loginTime", resultSet.getTimestamp("loginTime"));
              userTypeJSON.put("logoutTime", resultSet.getTimestamp("LogoutTime"));
              array.put(userTypeJSON);
          }
          return array;
        }
        catch(Exception e){
            System.out.println("Error retrieving user login info: "+e.toString());
            return new JSONArray();
       }
    }
    
    @Override
    public JSONArray getAllGamesByPublisher(int publisherID){
        try {
          JSONArray array = new JSONArray();
          ResultSet resultSet = DBConnector.getInstance().execute("select * from "+dbName+".gamesStoreInfo where publisherID = "+publisherID);
          
          return compileGamesResultSet(resultSet);
      }
      catch(Exception e){
          System.out.println("Error retrieving store info: "+e.toString());
          return new JSONArray();
      }
    }  
    
    @Override
    public int getGameID(int publisherID){
        try {
          ResultSet resultSet = DBConnector.getInstance().execute("select MAX(productID) from "+dbName+".gamesStoreInfo where publisherID = "+publisherID);
          if(resultSet.next()){
              return resultSet.getInt("MAX(productID)");
          }
          return -1;
      }
      catch(Exception e){
          System.out.println("Error retrieving store info: "+e.toString());
          return -1;
      }
    }
    
    public JSONArray compileGamesResultSet(ResultSet resultSet){
        JSONArray array = new JSONArray();
        try {
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
        } catch (SQLException ex) {
            Logger.getLogger(DBQueryParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(DBQueryParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }
    
    public JSONArray compileMoviesResultSet(ResultSet resultSet){
        JSONArray array = new JSONArray();
        try {
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
        } catch (SQLException ex) {
            Logger.getLogger(DBQueryParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(DBQueryParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }

    @Override
    public JSONArray getAllMoviesByPublisher(int publisherID) {
        try {
          JSONArray array = new JSONArray();
          ResultSet resultSet = DBConnector.getInstance().execute("select * from "+dbName+".movieStoreInfo where publisherID = "+publisherID);
          
          return compileMoviesResultSet(resultSet);
      }
      catch(Exception e){
          System.out.println("Error retrieving store info: "+e.toString());
          return new JSONArray();
      }
    }

    @Override
    public int addProduct(String name, int publisherID) {try {
             String sql = "Insert into  "+dbName+".products (publisherID, name) values (? , ?)";
             PreparedStatement preparedStatement = DBConnector.getInstance().getPreparedStatement(sql);
             
             
             preparedStatement.setInt(1, publisherID);
             preparedStatement.setString(2, name);
             
                 preparedStatement.executeUpdate();
          ResultSet resultSet = DBConnector.getInstance().execute("select MAX(productID) from "+dbName+".products where publisherID = "+publisherID);
          
          if(resultSet.next()){
              return resultSet.getInt("MAX(productID)");
          }
          return -1;
         } catch (SQLException ex) {
             Logger.getLogger(DBWriter.class.getName()).log(Level.SEVERE, null, ex);
             return -1;
         }
    }
    
    
    @Override
    public int getPubID(String name) {
        try {
          ResultSet resultSet = DBConnector.getInstance().execute("select publisherID from "+dbName+".publisherinfo where userName = '"+name+"'");
          
          if(resultSet.next()){
              return resultSet.getInt("publisherID");
          }
          return -1;
         } catch (SQLException ex) {
             Logger.getLogger(DBWriter.class.getName()).log(Level.SEVERE, null, ex);
             return -1;
         }
    }
    @Override
    public JSONArray getCart(String userName){
        try {
            JSONArray array = new JSONArray();
            ResultSet resultSet = DBConnector.getInstance().execute("select productID,name, price from "+dbName+".gamesStoreinfo where productID in (select productID from "+dbName+".carts where userName = '" + userName+"') union select  productID, name, price from "+dbName+".movieStoreinfo where productID in (select productID from "+dbName+".carts where userName = '" + userName+"')");
            if(resultSet.next()){
                JSONObject obj = new JSONObject();
                obj.put("productID", resultSet.getInt("productID"));
                obj.put("name", resultSet.getString("name"));
                obj.put("price", resultSet.getDouble("price"));
                array.put(obj);   
            }
            
            return array;
        }
        catch(Exception e){
          System.out.println("Error retrieving cartInfo: "+e.toString());
          return new JSONArray();
      }
    }
}
