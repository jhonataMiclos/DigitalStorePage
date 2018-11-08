/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import DBHandler.DBWriter;

/**
 *
 * @author jhonata
 */
public class RemoveGameCommand implements Command{
    private String gameSelected;
    private DBWriter dbWriter;
    
    public RemoveGameCommand() {
        gameSelected = "";
        dbWriter = new DBWriter();
    }
    
    public void setUserSelected(String game) {
        gameSelected = game;
    }
    
    @Override
    public void execute() {
        dbWriter.RemoveGame(gameSelected);
    }
    
    
}
