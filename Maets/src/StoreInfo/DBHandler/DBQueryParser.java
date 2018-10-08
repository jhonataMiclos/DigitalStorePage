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
    
  
  public List<String[]> getAllTeams(){//Gets a list of all the teams in a two-dimensional array.
      try {
        ArrayList<String[]> arr = new ArrayList<String[]>();
        ResultSet resultSet = DBConnector.getInstance().execute("select * from "+dbName+".gameStoreInfo");
        while(resultSet.next()){
            String[] sArr = new String[8];
            sArr[0] = ""+resultSet.getInt("productID");
            sArr[1] = resultSet.getString("name");
            sArr[2] = ""+resultSet.getDouble("price");
            sArr[3] = ""+resultSet.getInt("ageRating");
            sArr[4] = resultSet.getString("description");
            sArr[5] = resultSet.getString("minimumSpecs");
            sArr[6] = resultSet.getString("genre");
            sArr[7] = ""+resultSet.getInt("publisherID");
            arr.add(sArr);
        }
        return arr;
    }
    catch(Exception e){
        return new ArrayList<String[]>();
    }
  }
  
}
