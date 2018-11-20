/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import DBHandler.RepositoryAccessMethodFactory;
import DBHandler.RepositoryWriter;

/**
 *
 * @author Vilius
 */
public class PromoteToAdminCommand implements Command {

    private String userSelected;
    private RepositoryWriter dbWriter;
    
    public PromoteToAdminCommand(String user) {
        userSelected = "";
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory(); 
        dbWriter = rf.getRepoWriter();
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
