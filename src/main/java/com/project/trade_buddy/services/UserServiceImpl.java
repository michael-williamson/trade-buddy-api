package com.project.trade_buddy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.trade_buddy.repository.UserRepository;
import com.project.trade_buddy.model.Trades;
import com.project.trade_buddy.model.User;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository; 

	@Override
	public User findByAuthId(String theId) {
         User user = userRepository.findByAuthId(theId);
         if(user == null){
            return null; 
         }
         return user; 
    }
    
    @Override
    public User save(User user) {
        return userRepository.save(user);   
    }

	@Override
	public List<Trades> getTrades(User user) {
        return user.getTrades(); 
	}
}
