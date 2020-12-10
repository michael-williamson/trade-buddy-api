package com.project.trade_buddy.model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="trades")
public class Trades{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name="ticker")
	private String ticker;
	@Column(name="number_of_shares")
	@JsonProperty("number_of_shares")
	private int numberOfShares;
	@Column(name="short_or_long")
	@JsonProperty("short_or_long")
	private String shortOrLong;
	@Column(name="buy_price")
	@JsonProperty("buy_price")
	private float buyPrice;
	@Column(name="sell_price")
	@JsonProperty("sell_price")
	private float sellPrice;
	@Column(name="day_or_swing")   
	@JsonProperty("day_or_swing")
	private String typeOfTrade;    
	@Column(name="short_price")
	@JsonProperty("short_price")
	private float shortPrice;
	@Column(name="cover_price")
	@JsonProperty("cover_price")
	private float coverPrice;
	@Column(name="start_date")
	@JsonProperty("start_date")
	private LocalDate startDate;
	@Column(name="end_date")
	@JsonProperty("end_date")
	private LocalDate endDate;
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
	private User user; 
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public int getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public String getShortOrLong() {
		return shortOrLong;
	}

	public void setShortOrLong(String shortOrLong) {
		this.shortOrLong = shortOrLong;
	}

	public float getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(float buyPrice) {
		this.buyPrice = buyPrice;
	}

	public float getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(float sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getTypeOfTrade() {
		return typeOfTrade;
	}

	public void setTypeOfTrade(String dayOrSwing) {
		this.typeOfTrade = dayOrSwing;
	}

	public float getShortPrice() {
		return shortPrice;
	}

	public void setShortPrice(float shortPrice) {
		this.shortPrice = shortPrice;
	}

	public float getCoverPrice() {
		return coverPrice;
	}

	public void setCoverPrice(float coverPrice) {
		this.coverPrice = coverPrice;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	// public User getUser() {
	// 	return user;
	// }

	// public User setUser(User user) {
	// 	return this.user = user;
	// }
	

}
  