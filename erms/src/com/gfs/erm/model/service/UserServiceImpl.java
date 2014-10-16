package com.gfs.erm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  

import com.gfs.erm.exception.DataAccessException;
import com.gfs.erm.exception.UserAlreadyExistsException;
import com.gfs.erm.model.bo.User;
import com.gfs.erm.model.dao.UserDao;

@Service("userService")   
public class UserServiceImpl implements UserService {  
    
	@Autowired
	private UserDao userDao;
	
	@Override  
	public User authenticate(String username, String password) {
        User u = getUser(username);
        if (u != null && password.equals(u.getPassword())) {
            return u;
        }
        return null;
    }

	@Override  
	public User getUser(String username) {
        User user=null;
		try {
			user= userDao.get(username);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
    }
	
	@Override  
	public List<User> getUserList() {
        List<User> userList=null;
		try {
			userList= userDao.getList();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
    }

	@Override  
	public void addUser(User user) throws UserAlreadyExistsException {
        User u = getUser(user.getUserName());
        if (u != null) {
            //register.user.already.exists
            throw new UserAlreadyExistsException();
        }
        try {
			userDao.saveEntity(user);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			throw new UserAlreadyExistsException();
		}
    }

	

	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
}
