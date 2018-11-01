/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memento;

import javax.swing.JPanel;

/**
 *
 * @author Dev Mode
 */
public class Memento {
   private JPanel state;

   public Memento(JPanel state){
      this.state = state;
   }

   public JPanel getState(){
      return state;
   }	
}
