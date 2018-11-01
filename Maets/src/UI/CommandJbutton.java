/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import Common.Command;
import javax.swing.JButton;
/**
 *
 * @author Dev Mode
 */
public class CommandJbutton extends JButton implements Command {
    
    public Command command;
    
  public CommandJbutton(Command command){
      super();
      this.command = command;
  }
  public void setCommand(Command command){
      this.command = command;
  }
  public void execute(){
      command.execute();
  }   
}
