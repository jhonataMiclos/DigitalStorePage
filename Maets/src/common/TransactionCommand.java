/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import Controller.TransactionHandler;
import Controller.UIHandler;

/**
 *
 * @author Dev Mode
 */
public class TransactionCommand implements Command {
    private TransactionHandler handler;
    private boolean valid;
    public TransactionCommand( UIHandler uiHandler,boolean valid){
        this.handler=new TransactionHandler(uiHandler);
        this.valid=valid;
    }
    @Override
    public void execute() {
    if(valid){
        boolean insert =handler.AddToLibrary();
        boolean delete =handler.RemoveFromCart();
       if(!insert&&!delete){
            System.out.println("Error : adding to library or clearing cart");
       }
    }else{
            System.out.println("Error : Invalid CardNumber");
       }
               
    }
    
}
