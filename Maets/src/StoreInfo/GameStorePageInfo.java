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
    private int publisherID;
    
    
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
    
    @Override
    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public String displayStorePage() {
        String listing = "";
        listing += gameName+"\n"+description+"\n"+price+"\n"+minimumSpecs+"\n"+region;
        return listing;
    }

    @Override
    public String displayListing() {
        String listing = "";
        listing += gameName+"\t"+description+"\t"+price;
        return listing;
    }

    void setPublisherID(int publisherID) {
        this.publisherID = publisherID;
    }

    
}
