/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBHandler.DBWriter;

/**
 *
 * @author jhonata
 */
public class LoggingInterceptor implements ConnectionReplyInterceptor {
    private DBWriter dbWriter = new DBWriter();
    static LoggingInterceptor interceptor = new LoggingInterceptor();
    @Override
    public void preRemoteReply(ConnectionReplyContext context) {
        System.out.println("User connected at time - " + context.getStartTime());
        dbWriter.insertLoginTime(context.getUserName(), context.getStartTime());
        
    }

    @Override
    public void postRemoteReply(ConnectionReplyContext context) {
      
        System.out.println(context.getUserName());
        dbWriter.insertLogoutTime(context.getUserName(), context.getStartTime());
    }
     public static LoggingInterceptor getInterceptor(){
       return interceptor;
       
   }
}
