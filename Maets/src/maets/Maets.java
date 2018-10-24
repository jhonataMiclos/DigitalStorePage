/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maets;

import Controller.UIHandler;
import UI.LoginPanel;
import StoreInfo.StoreListing;
import StoreInfo.StoreListingFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author jakec
 */
public class Maets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<StoreListing> listings = StoreListingFactory.getAllGames();
        
        UIHandler ui = new UIHandler();
        
        for(int x = 0; x < listings.size();x++){
            System.out.println(""+x+".)\n"+listings.get(x).displayListing());
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a listing number for more info:   ");
        int input = Integer.parseInt(in.nextLine());
        System.out.println(listings.get(input).displayStorePage());
    }
}
