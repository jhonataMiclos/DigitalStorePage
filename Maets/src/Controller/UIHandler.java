package Controller;

import StoreInfo.DBHandler.RepositoryAccess;
import StoreInfo.DBHandler.RepositoryAccessMethodFactory;
import StoreInfo.GameStorePageInfoFactory;
import StoreInfo.StoreListing;
import UI.LoginPanel;
import UI.SignUpPanel;
import java.util.ArrayList;
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
        LoginPanel loginPanel = new LoginPanel();
        loginPanel.uiHandler = this;
        mainFrame.add(loginPanel);
        mainFrame.setSize(500, 500);
    }
    
    public void displaySignUpPanel() {
        mainFrame.getContentPane().removeAll();
        mainFrame.repaint();
        
        
        String[] userTypes = getAllUserTypes();
        SignUpPanel signUpPanel = new SignUpPanel(userTypes);
        signUpPanel.uiHandler = this;
        mainFrame.add(signUpPanel);
        mainFrame.setSize(500, 501);
    }
    
    private String[] getAllUserTypes(){
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
}
