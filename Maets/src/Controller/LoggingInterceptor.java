/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBHandler.DBWriter;
import DBHandler.RepositoryAccessMethodFactory;
import DBHandler.RepositoryWriter;

/**
 *
 * @author jhonata
 */
public class LoggingInterceptor implements ConnectionReplyInterceptor {
    private RepositoryWriter dbWriter;
    private static LoggingInterceptor interceptor  ;
    
    public LoggingInterceptor(){
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory(); 
        dbWriter = rf.getRepoWriter();
    }
    
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
    public static synchronized LoggingInterceptor getInterceptor(){//Singleton stuff
      if(interceptor==null){
          interceptor = new LoggingInterceptor();
      }
      return interceptor;
    }
}
