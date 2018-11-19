/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;
import Memento.CareTaker;
import Memento.Memento;
import javax.swing.*;
/**
 *
 * @author Dev Mode
 */
public class NavigateToCommand implements Command {
    private JPanel location;
    private JFrame mainFrame;
    private int type;
    
    public NavigateToCommand(JPanel location,JFrame mainFrame){
        this.location = location;
        this.mainFrame = mainFrame;
        type =0;
    }
    public NavigateToCommand(Memento location,JFrame mainFrame){
        this.location = location.getState();
        this.mainFrame = mainFrame;
        type =1;
    }
    
    
    @Override
    public void execute() {
      mainFrame.getContentPane().removeAll();
        mainFrame.repaint();
        
        mainFrame.add(location);
        mainFrame.setSize(601, 600);
        mainFrame.setSize(600, 600);
        if(type == 0)
            CareTaker.getInstance().add(new Memento(location));
    }
    
}
