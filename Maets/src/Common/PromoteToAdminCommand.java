/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import DBHandler.DBWriter;

/**
 *
 * @author Vilius
 */
public class PromoteToAdminCommand implements Command {

    private String userSelected;
    private DBWriter dbWriter;
    
    public PromoteToAdminCommand() {
        userSelected = "";
        dbWriter = new DBWriter();
    }
    
    public void setUserSelected(String user) {
        userSelected = user;
    }
    
    @Override
    public void execute() {
        dbWriter.promoteUserToAdmin(userSelected);
    }
    
}
