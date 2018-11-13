
package Controller;

/**
 *
 * @author jhonata
 */
public interface ConnectionReplyInterceptor {

    public void preRemoteReply(ConnectionReplyContext context); 
    public void postRemoteReply(ConnectionReplyContext context); 
    
}
