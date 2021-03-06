/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publisher;

/**
 *
w
 */

import DBHandler.RepositoryAccess;
import DBHandler.RepositoryAccessMethodFactory;
import Launchers.Launcher;
import Launchers.ProductLauncher;
import storeinfo.GameStorePageInfo;
import storeinfo.MovieStorePageInfo;
import storeinfo.StoreListing;

public class PublisherProductData {

    
    private StoreListing storeListing;
    private Launcher launcher;
    private int publisherID;

    public PublisherProductData(int publisherID){
        this.publisherID = publisherID;
    }
    
    public PublisherProductData(StoreListing storeListing, Launcher launcher,int publisherID){
        setStoreListing(storeListing);
        setLauncher(launcher);
        this.publisherID = publisherID;
    }
    
    void setStoreListing(StoreListing storeListing){
        this.storeListing = storeListing;
    }
    
    public void setGameStoreListing(String name, Double price, int ageRating, String genre,String desc, String minSpecs){
        this.storeListing = new GameStorePageInfo( name,  price,  ageRating,  genre, desc, minSpecs) ;
    }
    
    void setLauncher(Launcher launcher){
        this.launcher = launcher;
    }
    
    void updatePrice(Double updatedPrice){
        storeListing.setPrice(updatedPrice);
    }
    
    void play(){
        launcher.play();
    }

    public void setLauncher(String file) {
        launcher = new ProductLauncher();
        launcher.setFileLocation(file);
    }
    
    public boolean store(){
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory();
        RepositoryAccess ra =  rf.getRepoAccess();
        int id = ra.addProduct(storeListing.getName(), publisherID);
        if(id >= 0){
            storeListing.setID(id);
            storeListing.addToRepo();
            launcher.setProductID(id);
            return launcher.addToRepo();
        } else {
            System.out.println("Failed to store: "+id);
            return false;
        }
    }
    
    public void setPubID(int id){
        storeListing.setPublisherID(id);
    }

    public void setMovieStoreListing(String name, double price, int ageRating, String genre, String desc, int runtime) {
        this.storeListing = new MovieStorePageInfo( name,  price,  ageRating,  genre, desc, runtime);
    }
}
