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
import DBHandler.DBWriter;
import java.util.Date;

/**
 *
 * @author jhonata
 */
public class LogoutCommand implements Command{
    private DBWriter dbWriter;
    private String userName = "";
    public LogoutCommand(String userName) {
        dbWriter = new DBWriter();
        this.userName = userName;
    }
    @Override
    public void execute() {
        
        ConnectionReplyInterceptor cri = LoggingInterceptor.getInterceptor();
                
        LoggingDispatcher dis = LoggingDispatcher.getDispatcher();

        ConnectionReplyContext context;  

        dis.registerLoggingInterceptor(cri);

        context = new ConnectionReplyContext(new Date(),this.userName); 

        dis.postRemoteReply(context);
        
    } 
    
}
