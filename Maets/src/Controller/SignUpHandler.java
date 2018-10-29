package Controller;

import DBHandler.RepositoryAccess;
import DBHandler.RepositoryAccessMethodFactory;
import DBHandler.DBWriter;
import org.json.JSONObject;

/**
 *
 * @author Vilius
 */
public class SignUpHandler {

    private RepositoryAccess rA = RepositoryAccessMethodFactory.getRepoAccess();
    private DBWriter dbWriter;
    
    public SignUpHandler() {
        dbWriter = new DBWriter();
    }

    public String validateSignUp(String username, String password, int userType, String publisherName) {
        if (!validateUserName(username)) {
            return "Invalid Username";
        }
        
        int value = getUserLogin(username);
        if (value != 0) {
            return "Username is already taken";
        }

        if (!validatePassword(password)) {
            return "Invalid Password";
        }

        if (userType == 1) {
            // Register user
            dbWriter.insertUser(username, password, userType);
            return "Success";
        }
        else if (userType == 2) {
            if (publisherName.isEmpty()) {
                return "Must provide a publisher name";
            }
            
            // Register publisher
            dbWriter.insertUser(username, password, userType);
        }
        
        
        return "Success";
    }

    private int getUserLogin(String userName) {
        try {
            JSONObject obj = rA.getLoginInfo(userName);
            return obj.getInt("typeID");
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());
            return 0;
        }
    }

    public boolean validateUserName(String name) {
        String pattern = "^[a-z0-9_-]{3,15}$";
        return name.matches(pattern);
    }

    public boolean validatePassword(String password) {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return password.matches(pattern);
    }
}
