/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreInfo.DBHandler;

import org.json.JSONArray;

/**
 *
 * @author jakec
 */
public interface RepositoryAccess {
    JSONArray getAllGames();
    JSONArray getAllMovies();
}
