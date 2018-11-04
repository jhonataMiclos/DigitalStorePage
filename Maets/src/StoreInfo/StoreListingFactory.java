/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreInfo;

import DBHandler.DBQueryParser;
import DBHandler.RepositoryAccess;
import DBHandler.RepositoryAccessMethodFactory;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jakec
 */
public class StoreListingFactory {
    
    public static List<StoreListing> getAll(){
         List<StoreListing> allList = getAllGames();
         List<StoreListing> movieList = getAllMovies();
         System.out.println("Movie list count = " + movieList.size());
         allList.addAll(movieList);
         
         return allList;
    }
    
    public static List<StoreListing> getAllGames(){
        RepositoryAccess rA = RepositoryAccessMethodFactory.getRepoAccess();
         JSONArray array = rA.getAllGames();
         List<StoreListing> sLArrList = new ArrayList<StoreListing>();
         for(int x = 0; x < array.length(); x++){
             try{
                sLArrList.add(GameStorePageInfoFactory.create(array.getJSONObject(x)));
             } catch(Exception e){
                 System.out.println("Error : "+e.toString());
             }
         }
         return sLArrList;
    }
    
    public static List<StoreListing> getAllMovies(){
        RepositoryAccess rA = RepositoryAccessMethodFactory.getRepoAccess();
         JSONArray array = rA.getAllMovies();
         List<StoreListing> sLArrList = new ArrayList<StoreListing>();
         System.out.println("movie count = " + array.length());
         for(int x = 0; x < array.length(); x++){
             try{
                sLArrList.add(MovieStorePageInfoFactory.create(array.getJSONObject(x)));
             } catch(Exception e){
                 System.out.println("Error : "+e.toString());
             }
         }
         return sLArrList;
    }
}
