/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import StoreInfo.DBHandler.RepositoryAccess;
import StoreInfo.DBHandler.RepositoryAccessMethodFactory;
import org.json.JSONObject;

/**
 *
 * @author jhonata
 */
public class LoginHandler {
    private RepositoryAccess rA = RepositoryAccessMethodFactory.getRepoAccess();
    
    public String validateLogin(String userName, String password)
    {
        if (validateUserName(userName) && validatePassword(password)){
           int value = getUserLogin(userName);
           if(value == 0 )
                return "User not in database";
           else
           {
               return "Success";
           }
        }
        return "Wrong password or user name";
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
}
