/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publisher;

/**
 *
 * @author jakec
 */

import Launchers.Launcher;
import StoreInfo.StoreListing;

public class PublisherProductData {

    
    private StoreListing storeListing;
    private Launcher launcher;

    
    public PublisherProductData(){
        
    }
    
    void setStoreListing(StoreListing storeListing){
        this.storeListing = storeListing;
    }
    
    void setLauncher(Launcher launcher){
        this.launcher = launcher;
    }
    
    void updatePrice(Double updatedPrice){
        //storeListing.setPrice(updatedPrice);
    }
}
