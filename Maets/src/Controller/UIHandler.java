package Controller;

import DBHandler.RepositoryAccess;
import DBHandler.RepositoryAccessMethodFactory;
import UI.LoginPanel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

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
        LoginPanel loginPanel = new LoginPanel(mainFrame);
        loginPanel.uiHandler = this;
        mainFrame.add(loginPanel);
        mainFrame.setSize(600, 600);
    }
    
    public void displaySignUpPanel() {
    
    }
    
    
}
