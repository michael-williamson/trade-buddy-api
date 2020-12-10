package com.project.trade_buddy.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.trade_buddy.model.Trades;
import com.project.trade_buddy.model.User;
import com.project.trade_buddy.model.Analysis;
import com.project.trade_buddy.model.ModalFormData;
import com.project.trade_buddy.repository.TradesRepository;

import org.springframework.stereotype.Service;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradesRepository tradesRepository;

    @Override      
    public List<Trades> findAll(){
        return tradesRepository.findAll(); 
    }   

    @Override
    public Trades save(Trades trade){
        return tradesRepository.save(trade); 
    }

    @Override
    public List<Trades> findByDate(User user, ModalFormData formData) {

        String endDateCheck = "";
        endDateCheck = formData.getEndDate() != null ? formData.getEndDate(): formData.getStartDate();
        if(formData.getTypeOfTrade().equals("both")){
        return tradesRepository.findByUserAndStartDateBetween(user,LocalDate.parse(formData.getStartDate()), LocalDate.parse(endDateCheck));
        }else{
        return tradesRepository.findByUserAndTypeOfTradeAndStartDateBetween(user, formData.getTypeOfTrade(),LocalDate.parse(formData.getStartDate()), LocalDate.parse(endDateCheck));
        }

    }

    @Override
    public void deleteById(Long id) {
        tradesRepository.deleteById(id);
    }

    @Override
    public Analysis analyzeTrades(List<Trades> trades, ModalFormData formData){ 

    Analysis analysis = new Analysis(); 
    int winningTrades = 0;
    int losingTrades = 0; 
    int dayTrades = 0;       
    int swingTrades = 0;    

    int numberOfTrades = trades.size(); 
     
    for(int i = 0; i < trades.size(); i++){
        int result = trades.get(i).getTypeOfTrade().equals("Day Trade") ? dayTrades++ : swingTrades++;
        
        if(trades.get(i).getBuyPrice() < trades.get(i).getSellPrice() || trades.get(i).getShortPrice() > trades.get(i).getCoverPrice()){
            winningTrades++;
        }else{
        losingTrades++;
        }

    }

    analysis.setNumberOfTrades(numberOfTrades);
    analysis.setWinningTrades(winningTrades);
    analysis.setLosingTrades(losingTrades);
    analysis.setTypeOfTrade(formData.getTypeOfTrade());
    analysis.setStartDate(formData.getStartDate());
    if(formData.getEndDate() != null){
        analysis.setEndDate(formData.getEndDate());
    }

    switch(formData.getTypeOfTrade()){
        case "both":
        analysis.setDayTrades(dayTrades);
        analysis.setSwingTrades(swingTrades);
        break;
        case "Day Trade":
        analysis.setDayTrades(dayTrades);
        break; 
        case "Swing Trade":
        analysis.setSwingTrades(swingTrades);
        break; 
    }

    return analysis; 

    } 
}