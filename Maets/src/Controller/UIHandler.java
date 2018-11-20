package Controller;

import DBHandler.DBWriter;
import DBHandler.RepositoryAccess;
import DBHandler.RepositoryAccessMethodFactory;
import DBHandler.RepositoryWriter;
import Launchers.Launcher;
import Launchers.ProductLauncher;
import storeinfo.StoreListing;
import storeinfo.StoreListingFactory;
import UI.LoginPanel;
import java.sql.Timestamp;
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
    
    private RepositoryAccess ra;
    private JFrame mainFrame;
    private LoginHandler loginHandler;
    private JSONArray cart;
    private String username;

    public UIHandler() {
        cart = null;
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory();
        ra =  rf.getRepoAccess();
        loginHandler = new LoginHandler();
        displayLoginPanel();
    }
    
    public void displayLoginPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.repaint();
        LoginPanel loginPanel = new LoginPanel(mainFrame, this);
        loginPanel.setUIHandler(this);
        mainFrame.add(loginPanel);
        mainFrame.setSize(600, 600);
    }
    
    public String getProductInfo(String productName) {
        StoreListingFactory sLF = new StoreListingFactory();
        List<StoreListing> listings = sLF.getAll();
        for (StoreListing listing : listings) {
            if (listing.getName().equals(productName)) {
                return listing.displayStorePage();
            }
        }
        
        return null;
    }
    public int[] getAllGames(){
        
        StoreListingFactory sLF = new StoreListingFactory();
        List<StoreListing> listings = sLF.getAll();
        int[]  results = new int[listings.size()];
        int x = 0;
        for (StoreListing listing : listings) {
            results[x] = listing.getProductID();  
            x++;
        }
        return results;
    }
    
    public void addToCart(String productName) {
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory(); 
        RepositoryWriter dbWriter = rf.getRepoWriter();
        StoreListing x;
        x = getFullProductInfo(productName);
        if(x==null){
            dbWriter.insertIntoCart(username, x.getProductID());
        }
        
    }
    public void pullDownCart(){
        
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory();
         RepositoryAccess ra =  rf.getRepoAccess();
        cart= ra.getCart(username);
    }
    public String[] getAllAvailableUserTypes(){
        
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory();
         RepositoryAccess ra =  rf.getRepoAccess();
         JSONArray array = ra.getAllUserTypes();
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
        
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory();
         RepositoryAccess ra =  rf.getRepoAccess();
        JSONArray array = ra.getAllUsersData();
        String[] result =  new String[array.length()];
        result = getAvarages(array);
        
        
        return result;
    }
    public String[] getAvarages(JSONArray array){
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
            x++;
        }
        return result;
    }
    private double calcTime(Timestamp start, Timestamp end){
        double result =(double)(end.getTime() - start.getTime());
        return result;
    }
    public String[] getAllUserNames() {
       
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory();
         RepositoryAccess ra =  rf.getRepoAccess();
         JSONArray array = ra.getAllUsers();
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
        
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory();
         RepositoryAccess ra =  rf.getRepoAccess();
         JSONArray array = ra.getAllUsers();
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
        if(cart != null){
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
        
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory();
         RepositoryAccess ra =  rf.getRepoAccess();
        JSONArray results = ra.getLibrary(username);
        
        String[] libraryItems;
        if(results != null){
         libraryItems = new String[results.length()];
         for(int x =0 ;x<libraryItems.length ;x++)
         {
            try{
             JSONObject currentObj = results.getJSONObject(x);
             libraryItems[x] = currentObj.getString("name");
            } catch(Exception e){
                 System.out.println("Error 1s: "+e.toString());
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
        
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory();
         RepositoryAccess ra =  rf.getRepoAccess();
        JSONArray results = ra.getProductIDsByUsername(username);
        
        int[] productIDs;
        if(results != null){
         productIDs = new int[results.length()];
         for(int x =0 ;x<productIDs.length ;x++)
         {
            try{
             JSONObject currentObj = results.getJSONObject(x);
             productIDs[x] = currentObj.getInt("productID");
            } catch(Exception e){
                 System.out.println("Error 2s: "+e.toString());
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
        StoreListingFactory sLF = new StoreListingFactory();
        List<StoreListing> listings = sLF.getAll();
        for (StoreListing listing : listings) {
            if (listing.getName().equals(productName)) {
                return listing;
            }
        }
        return null;
    }
    
    public void launchProduct(int productID) {
        Launcher launcher = new ProductLauncher();
        
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory();
         RepositoryAccess ra =  rf.getRepoAccess();
        String filePath = ra.getFilePath(productID);
        
        launcher.setFileLocation(filePath);
        launcher.play();
        
    }

    JSONArray getCartJson() {
        return cart;
    }
}
