/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author New User
 */
public class LoggingDispatcher implements ConnectionReplyInterceptor {
    
    List<ConnectionReplyInterceptor> interceptors = new ArrayList<ConnectionReplyInterceptor>(); 
    
    static LoggingDispatcher dispatcher = new LoggingDispatcher(); 
    
    public void registerLoggingInterceptor(ConnectionReplyInterceptor interceptor){
        interceptors.add(interceptor);
        System.out.println("Interceptor registered."); 
    }
    
    @Override
    public Date preRemoteReply(ConnectionReplyContext context) {
        ConnectionReplyInterceptor interceptor = interceptors.get(interceptors.size() - 1);
        return interceptor.preRemoteReply(context);
        
    }

    @Override
    public Date postRemoteReply(ConnectionReplyContext context) {
        ConnectionReplyInterceptor interceptor = interceptors.get(interceptors.size() - 1);
        return interceptor.preRemoteReply(context);
    }
    
   public static LoggingDispatcher getDispatcher(){
       return dispatcher;
       
   }
    
}
