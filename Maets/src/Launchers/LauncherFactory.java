/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Launchers;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jakec
 */
public class LauncherFactory {
    public Launcher makeGameLauncher(JSONObject launcherInfo){
        try {
            Launcher launcher = new Launcher();
            launcher.setFileLocation(launcherInfo.getString("fileLocation"));
            launcher.setProductID(launcherInfo.getInt("productID"));
            launcher.setRevisionNumber(launcherInfo.getDouble("revisionNumber"));
            return launcher;
        } catch (JSONException ex) {
            Logger.getLogger(LauncherFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
