/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreInfo.DBHandler;

/**
 *
 * @author jakec
 */
public class RepositoryAccessMethodFactory {
    RepositoryAccess getRepoAccess(){
        return new DBQueryParser();
    }
}
