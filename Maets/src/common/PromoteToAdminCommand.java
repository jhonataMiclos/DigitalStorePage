/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import DBHandler.DBWriter;

/**
 *
 * @author Vilius
 */
public class PromoteToAdminCommand implements Command {

    private String userSelected;
    private DBWriter dbWriter;
    
    public PromoteToAdminCommand(String user) {
        userSelected = "";
        dbWriter = new DBWriter();
         userSelected = user;
    }
    
    public void setUserSelected(String user) {
        userSelected = user;
    }
    
    @Override
    public void execute() {
        dbWriter.promoteUserToAdmin(userSelected);
    }
    
}
