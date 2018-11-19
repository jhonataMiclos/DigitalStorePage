/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import Controller.UIHandler;

/**
 *
 * @author Vilius
 */
public class AddToCartCommand implements Command {

    private UIHandler uiHandler;
    private String productName;
    
    public AddToCartCommand(UIHandler uiHandler, String productName) {
        this.uiHandler = uiHandler;
        this.productName = productName;
    }
    
    @Override
    public void execute() {
        uiHandler.addToCart(productName);
    }
    
}
