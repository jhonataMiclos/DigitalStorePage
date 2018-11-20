/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import storeinfo.StoreListing;
import storeinfo.StoreListingFactory;
import java.util.List;

/**
 *
 * @author Vilius
 */
public class StorePageHandler {
    
    public Object[][] getAllProductListing() {
        StoreListingFactory sLF = new StoreListingFactory();
        List<StoreListing> storeListingList = sLF.getAll();
        Object[][] storeListingArr = new Object[storeListingList.size()][3];
        
        for (int i = 0; i < storeListingArr.length; i++) {
            String tempListing = storeListingList.get(i).displayListing();
            String[] splitListing = tempListing.split("\t");
            storeListingArr[i][0] = splitListing[0];
            storeListingArr[i][1] = splitListing[1];
            storeListingArr[i][2] = Double.parseDouble(splitListing[2]);
        }
        
        return storeListingArr;
    }
    
}
