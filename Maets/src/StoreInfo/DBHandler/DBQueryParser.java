/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreInfo.DBHandler;

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
          ResultSet resultSet = DBConnector.getInstance().execute("select * from "+dbName+".gamesStoreInfo");
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
}
