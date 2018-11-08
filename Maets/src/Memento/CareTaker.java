/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memento;

/**
 *
 * @author Dev Mode
 */
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class CareTaker {
    private static CareTaker instance;
    public static synchronized CareTaker getInstance(){//Singleton stuff
        if(instance==null){
           instance = new CareTaker();
      }
      return instance;
  }
   private List<Memento> mementoList = new ArrayList<Memento>();

   public void add(Memento state){
      mementoList.add(state);
   }

   public Memento get(int n){
        Memento x;
        x = mementoList.get(mementoList.size()-n);
        for(int i=1 ;i<n;i++){
            mementoList.remove(mementoList.size()-i);
        }
      return (x);
   }
}
