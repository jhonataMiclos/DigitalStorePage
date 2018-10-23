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
public class MovieStorePageInfoFactory {
    public static StoreListing create(JSONObject json) throws JSONException{
        return getMovieInfo(json);
    }
    
    
    private static MovieStorePageInfo getMovieInfo(JSONObject json) throws JSONException{
        MovieStorePageInfo mspi = new MovieStorePageInfo(json.getInt("productID"));
        mspi.setMovieName(json.getString("name"));
        mspi.setPrice(json.getDouble("price"));
        mspi.setAgeRating(json.getInt("ageRating"));
        mspi.setDescription(json.getString("description"));
        mspi.setRuntime(json.getInt("runtime"));
        mspi.setGenre(json.getString("genre"));
        mspi.setPublisherID(json.getInt("publisherID"));
        return mspi;
    }
}
