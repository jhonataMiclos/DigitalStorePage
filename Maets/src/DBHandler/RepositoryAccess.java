/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHandler;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jakec
 */
public interface RepositoryAccess {
    JSONArray getAllGames();
    JSONArray getAllMovies();
    JSONArray getAllUserTypes();
    JSONArray getAllUsers();
    JSONObject getLoginInfo(String userName);
    JSONArray getAllUsersData();
}
