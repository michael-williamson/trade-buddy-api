package com.project.trade_buddy.repository;

import java.time.LocalDate;
import java.util.List;

import com.project.trade_buddy.model.Trades;
import com.project.trade_buddy.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradesRepository extends JpaRepository<Trades, Long>  {

    List<Trades> findByUserAndTypeOfTradeAndStartDateBetween(User user, String typeOfTrade, LocalDate startDate,LocalDate endDate);   

    List<Trades> findByUserAndStartDateBetween(User user, LocalDate startDate,LocalDate endDate);   
    
}
  