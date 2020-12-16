package com.project.trade_buddy.controller;

import java.security.Principal;
import java.util.List;

import com.project.trade_buddy.model.Trades;
import com.project.trade_buddy.model.User;
import com.project.trade_buddy.services.TradeService;
import com.project.trade_buddy.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://main--trade-buddy.netlify.app", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/authorize", produces = MediaType.APPLICATION_JSON_VALUE)
public class TradesController {
    @Autowired
    private TradeService tradeService; 

    @Autowired
    private UserService userService; 

    @PostMapping(value = "/trades")
    public List<Trades> createTrade(@RequestBody Trades trades,Principal principal){
        final User userInstance = userService.findByAuthId(principal.getName());

            userInstance.addTrades(trades);   
         userService.save(userInstance);
            return userInstance.getTrades(); 

}

    @PutMapping(value = "/trades")
    public List<Trades> updateTrade(@RequestBody Trades trade,Principal principal){
        tradeService.save(trade);
        final User userInstance = userService.findByAuthId(principal.getName());
            return userInstance.getTrades(); 
}

    @DeleteMapping(value = "/trades/{id}")
    public List<Trades> deleteTrade(@PathVariable Long id,Principal principal){
        tradeService.deleteById(id);
        final User userInstance = userService.findByAuthId(principal.getName());
            return userInstance.getTrades(); 
}

    @GetMapping(value = "/trades")
    public List<Trades> getUserTrades(Principal principal){
        User user = userService.findByAuthId(principal.getName());

        if(user == null){
            User newUser = new User(); 
            newUser.setAuthId(principal.getName());  
            userService.save(newUser);   
            return newUser.getTrades(); 
        }  

        return userService.getTrades(user); 
    }   
}
