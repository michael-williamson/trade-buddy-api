package com.project.trade_buddy.services;

import java.util.List;

import com.project.trade_buddy.model.Analysis;
import com.project.trade_buddy.model.ModalFormData;
import com.project.trade_buddy.model.Trades;
import com.project.trade_buddy.model.User;

public interface TradeService {

    public List<Trades> findAll();

    public Trades save(Trades trade);

    public List<Trades> findByDate(User user, ModalFormData formData); 

    public void deleteById(Long id); 

    public Analysis analyzeTrades(List<Trades> trades,ModalFormData formData);
}
