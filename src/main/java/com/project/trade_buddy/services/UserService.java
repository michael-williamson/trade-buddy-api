package com.project.trade_buddy.services;

import java.util.List;

import com.project.trade_buddy.model.Trades;
import com.project.trade_buddy.model.User;

public interface UserService {
    public User findByAuthId(String theId); 

    public User save(User user); 

    public List<Trades> getTrades(User user);
}
