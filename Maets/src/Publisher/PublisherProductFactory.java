/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publisher;

import Launchers.Launcher;
import Launchers.LauncherFactory;
import StoreInfo.GameStorePageInfoFactory;
import StoreInfo.MovieStorePageInfoFactory;
import StoreInfo.StoreListing;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jakec
 */
public class PublisherProductFactory {
    public static PublisherProductData makeNewGame(JSONObject info) throws Exception{
        try {
            Launcher launcher = LauncherFactory.makeGameLauncher(info.getJSONObject("Launcher"));
            StoreListing sL = GameStorePageInfoFactory.getGameInfo(info.getJSONObject("StoreInfo"));
            return new PublisherProductData(sL, launcher);
        } catch (JSONException ex) {
            Logger.getLogger(PublisherProductFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public static PublisherProductData makeNewMovie(JSONObject info) throws Exception{
        try {
            Launcher launcher = LauncherFactory.makeGameLauncher(info.getJSONObject("Launcher"));
            StoreListing sL = MovieStorePageInfoFactory.getMovieInfo(info.getJSONObject("StoreInfo"));
            return new PublisherProductData(sL, launcher);
        } catch (JSONException ex) {
            Logger.getLogger(PublisherProductFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
}
