/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhonta
 */
public class LoggingDispatcher implements ConnectionReplyInterceptor {
    
    List<ConnectionReplyInterceptor> interceptors = new ArrayList<ConnectionReplyInterceptor>(); 
    
    private static LoggingDispatcher dispatcher  ; 
    
    public void registerLoggingInterceptor(ConnectionReplyInterceptor interceptor){
        interceptors.add(interceptor);
        System.out.println("Interceptor registered."); 
    }
    
    @Override
    public void preRemoteReply(ConnectionReplyContext context) {
        ConnectionReplyInterceptor interceptor = interceptors.get(interceptors.size() - 1);
        interceptor.preRemoteReply(context);
        
    }

    @Override
    public void postRemoteReply(ConnectionReplyContext context) {
        ConnectionReplyInterceptor interceptor = interceptors.get(interceptors.size() - 1);
        interceptor.postRemoteReply(context);
    }
    
  
    public static synchronized LoggingDispatcher getDispatcher(){//Singleton stuff
      if(dispatcher==null){
          dispatcher = new LoggingDispatcher();
      }
      return dispatcher;
    }
}
