/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBHandler.RepositoryAccess;
import DBHandler.RepositoryAccessMethodFactory;
import java.util.Date;
import org.json.JSONObject;

/**
 *
 * @author jhonata
 */
public class LoginHandler {
    private RepositoryAccess rA;
    public LoginHandler() {
        
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory();
        rA =  rf.getRepoAccess();

    }
    public int validateLogin(String userName, String password)
    {
        if (validateUserName(userName) && validatePassword(password)){
           int value = getUserLogin(userName);
           if(value == 0) {
               return value;
           }
           else
           {             
                ConnectionReplyInterceptor cri = LoggingInterceptor.getInterceptor();
                
                LoggingDispatcher dis = LoggingDispatcher.getDispatcher();

                ConnectionReplyContext context;  

                dis.registerLoggingInterceptor(cri);

                context = new ConnectionReplyContext(new Date(), userName); 

                dis.preRemoteReply(context); 
                

                return value;
           }
        }
        
        return -1;
    }

    private int getUserLogin(String userName){
        try{
            JSONObject obj = rA.getLoginInfo(userName);
            return obj.getInt("typeID");
        }
        catch(Exception e){
            System.out.println("Error : "+e.toString());
            return 0;
        }
    } 
    private boolean validateUserName(String name){
        String pattern = "^[a-z0-9_-]{3,15}$";
        return name.matches(pattern);
    }
    private boolean validatePassword(String password){
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return password.matches(pattern);
    }

    void setFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
