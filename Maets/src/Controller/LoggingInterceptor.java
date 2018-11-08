/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Date;

/**
 *
 * @author New User
 */
public class LoggingInterceptor implements ConnectionReplyInterceptor {

    @Override
    public Date preRemoteReply(ConnectionReplyContext context) {
        System.out.println("User connected at time - " + context.getStartTime());
        return context.getStartTime();
    }

    @Override
    public Date postRemoteReply(ConnectionReplyContext context) {
        Date endTime = new Date();
        
        long timeDifference = endTime.getTime() - context.getStartTime().getTime(); 
        System.out.println("User spent " + timeDifference + " logged in.");
        return  endTime;
    }
    
}
