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
 * @author jhonata
 */
public class RemoveGameCommand implements Command{
    private int gameSelected;
    private RepositoryWriter dbWriter;
    
    public RemoveGameCommand(int gameId) {
        gameSelected = 0;
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory(); 
        dbWriter = rf.getRepoWriter();
        gameSelected = gameId;
    }
    
    public void setUserSelected(int gameId) {
        gameSelected = gameId;
    }
    
    @Override
    public void execute() {
        dbWriter.RemoveGame(gameSelected);
    }
    
    
}
