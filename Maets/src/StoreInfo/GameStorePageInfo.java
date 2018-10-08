/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreInfo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jakec
 */
public class GameStorePageInfo implements StoreListing  {
    
    private int gameID;
    private int ageRating;
    private String gameName;
    private String description;
    private String minimumSpecs;
    private String region;
    private List<String> genres;
    private double price;
    
    
    public GameStorePageInfo(int gameID){
        this.gameID = gameID;
        genres = new ArrayList<String>();
    }
    
    public void setAgeRating(int ageRating){
        this.ageRating = ageRating;
    }
    
    public void setGameName(String gameName){
        this.gameName = gameName;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setMinimumSpecs(String minimumSpecs){
        this.minimumSpecs = minimumSpecs;
    }
    
    
    public void setGenre(String... genre){
        for(String newGenre : genre){
            this.genres.add(newGenre);
        }
    }
    
    public void setRegion(String Region){
        this.region = region;
    }
    
    public void price(double price){
        this.price = price;
    }

    @Override
    public String displayStorePage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String displayListing() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
