/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author jakec
 */
public class Publisher {
    
    private List<PublisherProductData> pPD;
    private int selectedItem;
    private int publisherID;
    private Boolean changesMade = false;
    
    public Publisher(int publisherID){
        this.selectedItem = -1;
        this.publisherID = publisherID;
    }
    
    private void getAllPublisherGames(int publisherID){
        pPD = new ArrayList<PublisherProductData>();
    }
   
    public Boolean changesMade(){
        return changesMade;
    }
    
    public void selectPPD(int selectedItem){
        this.selectedItem = selectedItem;
    }
    
    public void updatePrice(Double updatedPrice){
        if(selectedItem >= 0){
            pPD.get(selectedItem).updatePrice(updatedPrice);
            changesMade = true;
        }
    }
    
    public void addMovie(JSONObject movieDetails){
        try {
            pPD.add(PublisherProductFactory.makeNewMovie(movieDetails, publisherID));
        } catch (Exception ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("Error: Movie data formatted incorrectly");
        }
    }
    
    public void addGame(JSONObject gameDetails){
        try {
            pPD.add(PublisherProductFactory.makeNewGame(gameDetails, publisherID));
        } catch (Exception ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("Error: Movie data formatted incorrectly");
        }
    }
}
