
package Controller;

import java.util.Date;


public interface ConnectionReplyInterceptor {
    
    public Date preRemoteReply(ConnectionReplyContext context); 
    public void postRemoteReply(ConnectionReplyContext context); 
    
}
