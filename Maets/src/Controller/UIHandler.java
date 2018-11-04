package Controller;

import DBHandler.RepositoryAccess;
import DBHandler.RepositoryAccessMethodFactory;
import StoreInfo.StoreListing;
import StoreInfo.StoreListingFactory;
import UI.LoginPanel;
import java.util.List;
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
