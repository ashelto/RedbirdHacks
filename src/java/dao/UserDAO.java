/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.User;

/**
 *
 * @author billylim
 */

public interface UserDAO {
    
    public int createUser(User aUser);
    public ArrayList findAll();
    public boolean findUser(User aUser); 
    public int updateUser(User aUser);
}
