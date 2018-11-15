package Controller;

import DBHandler.DBWriter;
import DBHandler.RepositoryAccess;
import DBHandler.RepositoryAccessMethodFactory;
import Launchers.Launcher;
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
    public JSONArray cart;
    private String username;

    public UIHandler() {
        cart = null;
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
        DBWriter dbWriter= new DBWriter();
        StoreListing x;
        x = getFullProductInfo(productName);
        dbWriter.insertIntoCart(username, x.getProductID());
        
    }
    public void pullDownCart(){
        RepositoryAccess rA = RepositoryAccessMethodFactory.getRepoAccess();
        cart= rA.getCart(username);
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

    public void setUsername(String usernameText) {
        username=usernameText;
    }
    public String getUsername() {
        return username;
    }

    public Object[][] getCart() {
        pullDownCart();
        Object[][] cartItems;
        if(cart != null || cart.length() > 0){
         cartItems = new Object[cart.length()][2];
         for(int x =0 ;x<cart.length();x++)
         {
            try{
             JSONObject currentObj = cart.getJSONObject(x);
             cartItems[x][0]=currentObj.getString("name");
             cartItems[x][1]=currentObj.getDouble("price");
            } catch(Exception e){
                 System.out.println("Error s: "+e.toString());
             }
        }
        }
        else{
             cartItems = new String[1][2];
             cartItems[0][0]="No";
             cartItems[0][1]="Products";
         }
        return cartItems;
        
    }
    
    public String[] getLibrary() {
        RepositoryAccess rA = RepositoryAccessMethodFactory.getRepoAccess();
        JSONArray results = rA.getLibrary(username);
        
        String[] libraryItems;
        if(results != null || results.length() > 0){
         libraryItems = new String[results.length()];
         for(int x =0 ;x<libraryItems.length ;x++)
         {
            try{
             JSONObject currentObj = results.getJSONObject(x);
             libraryItems[x] = currentObj.getString("name");
            } catch(Exception e){
                 System.out.println("Error s: "+e.toString());
             }
        }
        }
        else{
             libraryItems = new String[1];
             libraryItems[0] ="No products";
         }
        return libraryItems;
        
    }
    
    public int[] getProductIDsByUsername() {
        RepositoryAccess rA = RepositoryAccessMethodFactory.getRepoAccess();
        JSONArray results = rA.getLibrary(username);
        
        int[] productIDs;
        if(results != null || results.length() > 0){
         productIDs = new int[results.length()];
         for(int x =0 ;x<productIDs.length ;x++)
         {
            try{
             JSONObject currentObj = results.getJSONObject(x);
             productIDs[x] = currentObj.getInt("productID");
            } catch(Exception e){
                 System.out.println("Error s: "+e.toString());
             }
        }
        }
        else{
             productIDs = new int[1];
             productIDs[0] = -1;
         }
        return productIDs;
    }

    private StoreListing getFullProductInfo(String productName) {
        List<StoreListing> listings = StoreListingFactory.getAll();
        for (StoreListing listing : listings) {
            if (listing.getName().equals(productName)) {
                return listing;
            }
        }
        return null;
    }
    
    public void launchProduct(int productID) {
        Launcher launcher = new Launcher();
        
        RepositoryAccess rA = RepositoryAccessMethodFactory.getRepoAccess();
        String filePath = rA.getFilePath(productID);
        
        launcher.setFileLocation(filePath);
        launcher.play();
        
    }
}
