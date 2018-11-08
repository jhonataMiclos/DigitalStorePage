/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Controller.ConnectionReplyContext;
import Controller.ConnectionReplyInterceptor;
import Controller.LoggingDispatcher;
import Controller.LoggingInterceptor;
import Controller.LoginHandler;
import Controller.SingletonDispatcher;
import DBHandler.DBWriter;
import java.util.Date;

/**
 *
 * @author jhonata
 */
public class LogoutCommand implements Command{
    //private String gameSelected;
    private DBWriter dbWriter;
    
    public LogoutCommand() {
        //gameSelected = "";
        dbWriter = new DBWriter();
    }
    
    public void setUserSelected(String game) {
       // gameSelected = game;
    }
    
    @Override
    public void execute() {
        
        ConnectionReplyInterceptor cri = new LoggingInterceptor();
                
        LoggingDispatcher dis = LoggingDispatcher.getDispatcher();

        ConnectionReplyContext context;  

        dis.registerLoggingInterceptor(cri);

        context = new ConnectionReplyContext(new Date()); 

        Date dateTime = dis.preRemoteReply(context); 
        dbWriter.insertLogoutTime(LoginHandler.getUserLoggedIn(), dateTime);
        
        //dbWriter.RemoveGame(gameSelected);
    } 
    
}
