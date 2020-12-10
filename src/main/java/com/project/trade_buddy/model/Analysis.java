package com.project.trade_buddy.model;
  
public class Analysis {
    private int numberOfTrades = 0;
    private int winningTrades = 0; 
	private int losingTrades = 0;
	private int dayTrades= 0;
	private int swingTrades = 0; 
	private String typeOfTrade; 
	private String startDate;
	private String endDate; 
	

	public int getNumberOfTrades() {
		return numberOfTrades;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getTypeOfTrade() {
		return typeOfTrade;
	}
	public void setTypeOfTrade(String typeOfTrade) {
		this.typeOfTrade = typeOfTrade;
	}
	public int getDayTrades() {
		return dayTrades;
	}
	public void setDayTrades(int dayTrades) {
		this.dayTrades = dayTrades;
	}
	public int getSwingTrades() {
		return swingTrades;
	}
	public void setSwingTrades(int swingTrades) {
		this.swingTrades = swingTrades;
	}
	public void setNumberOfTrades(int numberOfTrades) {
		this.numberOfTrades = numberOfTrades;
	}
	public int getWinningTrades() {
		return winningTrades;
	}
	public void setWinningTrades(int winningTrades) {
		this.winningTrades = winningTrades;
	}
	public int getLosingTrades() {
		return losingTrades;
	}
	public void setLosingTrades(int losingTrades) {
		this.losingTrades = losingTrades;
	} 

    
}
