/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreInfo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jakec
 */
public class GameStorePageInfoFactory {
    public static StoreListing create(JSONObject json) throws JSONException{
        return getGameInfo(json);
    }
    
    
    private static GameStorePageInfo getGameInfo(JSONObject json) throws JSONException{
        GameStorePageInfo gspi = new GameStorePageInfo(json.getInt("productID"));
        gspi.setGameName(json.getString("name"));
        gspi.setPrice(json.getDouble("price"));
        gspi.setAgeRating(json.getInt("ageRating"));
        gspi.setDescription(json.getString("description"));
        gspi.setMinimumSpecs(json.getString("minimumSpecs"));
        gspi.setGenre(json.getString("genre"));
        gspi.setPublisherID(json.getInt("publisherID"));
        return gspi;
    }
}
