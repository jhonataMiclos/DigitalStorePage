/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;
import Memento.CareTaker;
import Memento.Memento;
import UI.LoginPanel;
import javax.swing.*;
/**
 *
 * @author Dev Mode
 */
public class NavigateToCommand implements Command {
    private JPanel location;
    private JFrame mainFrame;
    
    public NavigateToCommand(JPanel location,JFrame mainFrame){
        this.location = location;
        this.mainFrame = mainFrame;
    }
    
    @Override
    public void execute() {
      mainFrame.getContentPane().removeAll();
        mainFrame.repaint();
        
        mainFrame.add(location);
        mainFrame.setSize(601, 600);
        mainFrame.setSize(600, 600);
        
        CareTaker.getInstance().add(new Memento(location));
    }
    
}
