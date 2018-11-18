/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Common.DoNothingCommand;
import Common.NavigateToCommand;
import Controller.LoginHandler;
import Controller.UIHandler;
import DBHandler.RepositoryAccess;
import Memento.CareTaker;
import Memento.Memento;
import DBHandler.RepositoryAccessMethodFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jhonata
 */
public class LoginPanel extends javax.swing.JPanel {

    private UIHandler uiHandler;
    private LoginHandler handler = new LoginHandler();
    
    /**
     * Creates new form Login
     */
    public LoginPanel(JFrame mainFrame, UIHandler uiHandler) {
        this.frame = mainFrame;
        this.uiHandler = uiHandler;
        signUpB= new CommandJbutton(new NavigateToCommand(new SignUpPanel(frame,this,uiHandler),frame));
        loginB= new CommandJbutton(new DoNothingCommand());
        initComponents();
        
    }
    public void setUIHandler(UIHandler uiHandler){
       this.uiHandler =uiHandler;
    }

    LoginPanel(JFrame frame, JPanel panel, UIHandler uiHandler) {
       this.frame = frame;
       this.uiHandler = uiHandler;
       signUpB= new CommandJbutton(new NavigateToCommand(new SignUpPanel(frame,this,uiHandler),frame));
       loginB= new CommandJbutton(new DoNothingCommand());
       initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        userNameF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        passwordF = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        errorL = new javax.swing.JLabel();

        setToolTipText("");

        loginB.setText("Login");
        loginB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBActionPerformed(evt);
            }
        });

        signUpB.setText("Sign up");
        signUpB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBActionPerformed(evt);
            }
        });

        userNameF.setToolTipText("");
        userNameF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameFActionPerformed(evt);
            }
        });

        jLabel1.setToolTipText("user name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Login");

        passwordF.setToolTipText("password");

        jLabel3.setText("password");

        jLabel4.setText("username");
        jLabel4.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordF, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(84, 84, 84)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(144, 144, 144)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel4)
                                .addComponent(userNameF, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(84, 84, 84)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(errorL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(signUpB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(loginB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addComponent(jLabel3)))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(9, 9, 9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNameF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorL)
                .addGap(15, 15, 15)
                .addComponent(loginB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(signUpB)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>                        

    private void userNameFActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        
        
        
    }                                         

    private void loginBActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        String usernameText = userNameF.getText();
        String passwordText = String.valueOf(passwordF.getPassword());
        int loginResult = handler.validateLogin(usernameText, passwordText);
        
        switch (loginResult) {
            case -1:
                System.out.println("Incorrect user login");
                errorL.setText("Incorrect user login");
                break;
            case 0:
                System.out.println("User not in the database");
                errorL.setText("User not in the database");
                break;
            case 1:
                // Display user stuff
                uiHandler.setUsername(usernameText);
                loginB.setCommand(new NavigateToCommand(new ProductListingAdapted(frame,this,uiHandler),frame));
                loginB.execute();
                break;
            case 2:
                // Display publisher stuff
                uiHandler.setUsername(usernameText);
                RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory();
                RepositoryAccess ra =  rf.getRepoAccess();
                int id = ra.getPubID(usernameText);
                loginB.setCommand(new NavigateToCommand(new PublisherProductListingAdapted(frame,uiHandler, id),frame));
                loginB.execute();
                break;
            case 3:
                // Display admin stuff
                uiHandler.setUsername(usernameText);
                loginB.setCommand(new NavigateToCommand(new AdminPanelAdapted(frame,this,uiHandler),frame));
                loginB.execute();
                break;
            default:
                System.out.println("Failed user login");
                errorL.setText("Failed user login");
                break;
            
        }
    }                                      

    private void signUpBActionPerformed(java.awt.event.ActionEvent evt) {                                        
        signUpB.execute();
    }                                       

                    
    private javax.swing.JLabel errorL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private CommandJbutton signUpB;
    private javax.swing.JPasswordField passwordF;
    private CommandJbutton loginB;
    private javax.swing.JTextField userNameF;
    private javax.swing.JFrame frame;
       
  
}
