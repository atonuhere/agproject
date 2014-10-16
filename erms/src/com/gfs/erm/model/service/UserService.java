package com.gfs.erm.model.service;

import java.util.List;

import com.gfs.erm.exception.DataAccessException;
import com.gfs.erm.exception.UserAlreadyExistsException;
import com.gfs.erm.model.bo.User;

public interface UserService {
   
    public User authenticate(String username, String password) throws DataAccessException ;

    public User getUser(String username) throws DataAccessException;
    
    public void addUser(User user) throws UserAlreadyExistsException ;
    
    public List<User> getUserList() throws DataAccessException;
    
    
    
    
}
