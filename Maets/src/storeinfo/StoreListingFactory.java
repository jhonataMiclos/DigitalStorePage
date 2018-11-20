/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeinfo;

import DBHandler.RepositoryAccess;
import DBHandler.RepositoryAccessMethodFactory;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/**
 *
 * @author jakec
 */
public class StoreListingFactory {
    
    public List<StoreListing> getAll(){
         List<StoreListing> allList = getAllGames();
         List<StoreListing> movieList = getAllMovies();
         allList.addAll(movieList);
         
         return allList;
    }
    
    public List<StoreListing> getAllGames(){
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory();
         RepositoryAccess ra =  rf.getRepoAccess();
         JSONArray array = ra.getAllGames();
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
    
    public List<StoreListing> getAllMovies(){
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory();
         RepositoryAccess ra =  rf.getRepoAccess();
         JSONArray array = ra.getAllMovies();
         List<StoreListing> sLArrList = new ArrayList<StoreListing>();
         MovieStorePageInfoFactory mspif = new MovieStorePageInfoFactory();
         
         for(int x = 0; x < array.length(); x++){
             try{
                sLArrList.add(mspif.create(array.getJSONObject(x)));
             } catch(Exception e){
                 System.out.println("Error : "+e.toString());
             }
         }
         return sLArrList;
    }
    
    public List<StoreListing> getAllbyPublisher(int id){
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory();
         RepositoryAccess ra =  rf.getRepoAccess();
        JSONArray array = ra.getAllMoviesByPublisher(id);
        List<StoreListing> sLArrList = new ArrayList<StoreListing>();
        MovieStorePageInfoFactory mspi = new MovieStorePageInfoFactory();
        for(int x = 0; x < array.length(); x++){
            try{
               sLArrList.add(mspi.create(array.getJSONObject(x)));
            } catch(Exception e){
                System.out.println("Error : "+e.toString());
            }
        }
        array = ra.getAllGames();
        for(int x = 0; x < array.length(); x++){
            try{
               sLArrList.add(GameStorePageInfoFactory.create(array.getJSONObject(x)));
            } catch(Exception e){
                System.out.println("Error : "+e.toString());
            }
        }

        return sLArrList;

    }
}
