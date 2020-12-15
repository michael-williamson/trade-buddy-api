package com.project.trade_buddy.controller;

import java.security.Principal;
import java.util.List;

import com.project.trade_buddy.model.Analysis;
import com.project.trade_buddy.model.ModalFormData;
import com.project.trade_buddy.model.Trades;
import com.project.trade_buddy.model.User;
import com.project.trade_buddy.services.TradeService;
import com.project.trade_buddy.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://michael-williamson.github.io/trade_buddy_ts/", maxAge = 3600)
@RestController
@RequestMapping(path = "api/authorize", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnalysisController {

    @Autowired
    private TradeService tradeService; 

    @Autowired
    private UserService userService; 

    
    @CrossOrigin("https://michael-williamson.github.io/trade_buddy_ts/")
    @PostMapping(value = "/analysis")
    public Analysis getAnalysis(@RequestBody ModalFormData formData, Principal principal){

        User user = userService.findByAuthId(principal.getName());
        List<Trades> trades = tradeService.findByDate(user,formData); 

         return tradeService.analyzeTrades(trades,formData);
    
    }   
}  
