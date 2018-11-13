/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Date;

/**
 *
 * @author jhonata
 */
public class ConnectionReplyContext {
    
    private Date startTime;
    private String userName;
    
    public ConnectionReplyContext(Date startTime, String name){
        this.startTime = startTime; 
        this.userName = name;
    }
    
    public Date getStartTime(){
        return startTime; 
    }
    public String getUserName(){
        return userName;
    }
    
    
}
