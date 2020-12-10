package com.project.trade_buddy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; 
	
    @Column(name="auth_id")
    private String authId; 

	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="user_id")
    private List<Trades> trades; 

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;   
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public List<Trades> getTrades() {
		return trades;
	}

	public void setTrades(List<Trades> trades) {
		this.trades = trades;
	}
	
	//convenience method to help java out,  not necessary but helps java out
	public void addTrades(Trades theTrade) {
	
		if (trades == null) {
			trades = new ArrayList<>();
		}
		
		trades.add(theTrade);
	}

	

}
