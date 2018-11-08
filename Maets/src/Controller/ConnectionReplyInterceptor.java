
package Controller;

import java.util.Date;


public interface ConnectionReplyInterceptor {
    
    public Date preRemoteReply(ConnectionReplyContext context); 
    public Date postRemoteReply(ConnectionReplyContext context); 
    
}
