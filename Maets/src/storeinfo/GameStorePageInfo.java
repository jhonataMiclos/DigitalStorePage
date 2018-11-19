/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeinfo;

import DBHandler.DBWriter;
import DBHandler.RepositoryAccess;
import DBHandler.RepositoryAccessMethodFactory;
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

    public GameStorePageInfo(String name, Double price, int ageRating, String genre, String desc, String minSpecs) {
        this.ageRating = ageRating;
        this.genres= new ArrayList<String>();
        this.genres.add(genre);
        this.description = desc;
        this.gameName = name;
        this.minimumSpecs = minSpecs;
        this.price= price;
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
        listing += "Name: "+gameName+"<br/>Description: "+description+"<br/>Price: "+price+
                "<br/>Min Specs: "+minimumSpecs+"<br/>Age Rating: "+ageRating;
        return listing;
    }

    @Override
    public String displayListing() {
        String listing = "";
        listing += gameName+"\t"+description+"\t"+price;
        return listing;
    }

    
    @Override
    public void setPublisherID(int publisherID) {
        this.publisherID = publisherID;
    }

    @Override
    public String getName() {
        return gameName;
    }
    @Override
    public int getProductID() {
        return gameID;
    }
    @Override
    public int addToRepo() {
        DBWriter w = new DBWriter();
        if(w.insertNewGame(gameID, gameName, price, ageRating, description, minimumSpecs, genres.get(genres.size()-1), publisherID)){
            
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory();
         RepositoryAccess ra =  rf.getRepoAccess();
            return ra.getGameID(publisherID);
        } else{
           return -1;
        }
    }

    @Override
    public void setID(int id) {
        this.gameID = id;
    }    
}
