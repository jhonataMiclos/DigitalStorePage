package Controller;


import DBHandler.DBWriter;
import DBHandler.RepositoryAccess;
import DBHandler.RepositoryAccessMethodFactory;
import DBHandler.RepositoryWriter;
import org.json.JSONArray;
import org.json.JSONObject;

public class TransactionHandler {

    private RepositoryAccess rA;
    private DBWriter dbWriter;
    private UIHandler uiHandler;
    
    public TransactionHandler( UIHandler uiHandler) {
        dbWriter = new DBWriter();
        this.uiHandler=uiHandler;
        
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory();
        rA =  rf.getRepoAccess();
    }
    
    public boolean validateCard(String cardNumber) {
        String pattern = "^(?:4[0-9]{12}(?:[0-9]{3})?" +
" |  (?:5[1-5][0-9]{2}" +
"     | 222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}" +
" |  3[47][0-9]{13}" +
" |  3(?:0[0-5]|[68][0-9])[0-9]{11}" +
" |  6(?:011|5[0-9]{2})[0-9]{12}" +
" |  (?:2131|1800|35\\d{3})\\d{11}" +
")$";
        return true;
       // return cardNumber.matches(pattern);
    }
    public boolean AddToLibrary() {
       uiHandler.pullDownCart();
       JSONArray cart = uiHandler.cart;
        for(int x =0 ;x< cart.length();x++)
         {
            try{
             JSONObject currentObj = cart.getJSONObject(x);
            dbWriter.insertHistory(uiHandler.getUsername(),currentObj.getInt("productID"));
            } catch(Exception e){
                 System.out.println("Error s: "+e.toString());
                 return false;
            }
        }
        return true;
    }
    
    public boolean RemoveFromCart() {
        RepositoryAccessMethodFactory rf = new RepositoryAccessMethodFactory();
         RepositoryWriter rw =  rf.getRepoWriter();
        return rw.clearCart(uiHandler.getUsername());
    }
    

}
