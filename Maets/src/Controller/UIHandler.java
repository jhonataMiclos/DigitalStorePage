package Controller;

import DBHandler.RepositoryAccess;
import DBHandler.RepositoryAccessMethodFactory;
import StoreInfo.StoreListing;
import StoreInfo.StoreListingFactory;
import UI.LoginPanel;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Vilius
 */
public class UIHandler {
    
    private RepositoryAccess rA = RepositoryAccessMethodFactory.getRepoAccess();
    private JFrame mainFrame;
    private LoginHandler loginHandler;
    private List<String> cart;

    public UIHandler() {
        cart = new ArrayList<String>();
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        
        loginHandler = new LoginHandler();
        displayLoginPanel();
    }
    
    public void displayLoginPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.repaint();
        LoginPanel loginPanel = new LoginPanel(mainFrame, this);
        loginPanel.uiHandler = this;
        mainFrame.add(loginPanel);
        mainFrame.setSize(600, 600);
    }
    
    public String getProductInfo(String productName) {
        List<StoreListing> listings = StoreListingFactory.getAll();
        for (StoreListing listing : listings) {
            if (listing.getName().equals(productName)) {
                return listing.displayStorePage();
            }
        }
        
        return null;
    }
    public int[] getAllGames(){
        
        List<StoreListing> listings = StoreListingFactory.getAll();
        int[]  results = new int[listings.size()];
        int x = 0;
        for (StoreListing listing : listings) {
            results[x] = listing.getProductID();  
            x++;
        }
        return results;
    }
    
    public void addToCart(String productName) {
        cart.add(productName);
    }
    
    public String[] getAllAvailableUserTypes(){
        RepositoryAccess rA = RepositoryAccessMethodFactory.getRepoAccess();
         JSONArray array = rA.getAllUserTypes();
         String[] userTypes = new String[array.length()];
         for(int x = 0; x < array.length(); x++){
             try{
                JSONObject currentObj = array.getJSONObject(x);
                userTypes[x] = currentObj.getString("type");
             } catch(Exception e){
                 System.out.println("Error : "+e.toString());
             }
         }
         
         return userTypes;
    }
    public String[] getAllData(){
        RepositoryAccess rA = RepositoryAccessMethodFactory.getRepoAccess();
        JSONArray array = rA.getAllUsersData();
        String[] result =  new String[array.length()];
        result = getAvarages(array);
        
        
        return result;
    }
    private String[] getAvarages(JSONArray array){
        Map usersAvg = new HashMap<String, Double>();
        Map usersCount = new HashMap<String, Integer>();
        for(int x = 0; x < array.length(); x++){
            try{
               JSONObject currentObj = array.getJSONObject(x);
               String key = currentObj.getString("userName");
               double time = calcTime( (Timestamp)currentObj.get("loginTime"), (Timestamp)currentObj.get("logoutTime"));
               if (usersAvg.containsKey(key)){
                   usersAvg.put(key,(double)usersAvg.get(key) + time );
                   usersCount.put(key,(int)usersCount.get(key) + 1);        
               }
               else{
                   usersAvg.put(key,time );
                   usersCount.put(key,1); 
               }
            } catch(Exception e){
                System.out.println("Error : "+e.toString());
            }
        }
        String[] result = new String[usersAvg.size()];
        int x = 0;
        for (Object key: usersAvg.keySet()) {
            usersAvg.put(key,(double)usersAvg.get(key) / (int)usersCount.get(key));
            result[x] = String.format("%s: %f", key,(((double)usersAvg.get(key)/1000)/60));
        }
        return result;
    }
    private double calcTime(Timestamp start, Timestamp end){
        double result = end.getTime() - start.getTime();
        return result;
    }
    public String[] getAllUserNames() {
        RepositoryAccess rA = RepositoryAccessMethodFactory.getRepoAccess();
         JSONArray array = rA.getAllUsers();
         String[] userNames = new String[array.length()];
         for(int x = 0; x < array.length(); x++){
             try{
                JSONObject currentObj = array.getJSONObject(x);
                userNames[x] = currentObj.getString("userName");
             } catch(Exception e){
                 System.out.println("Error : "+e.toString());
             }
         }
         
         return userNames;
    }
    
    public int[] getAllUserTypes() {
        RepositoryAccess rA = RepositoryAccessMethodFactory.getRepoAccess();
         JSONArray array = rA.getAllUsers();
         int[] userTypes = new int[array.length()];
         for(int x = 0; x < array.length(); x++){
             try{
                JSONObject currentObj = array.getJSONObject(x);
                userTypes[x] = currentObj.getInt("typeID");
             } catch(Exception e){
                 System.out.println("Error : "+e.toString());
             }
         }
         return userTypes;
    }
}
