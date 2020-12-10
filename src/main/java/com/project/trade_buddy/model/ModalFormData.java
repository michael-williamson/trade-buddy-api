package com.project.trade_buddy.model;

public class ModalFormData {
    private String startDate;
    private String endDate; 
	private String typeOfTrade; 
	
	@Override
	public String toString(){
		return startDate + " " + endDate + " " + typeOfTrade;
	}


	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getTypeOfTrade(){
		return typeOfTrade; 
	}
	public void setTypeOfTrade(String typeOfTrade){
		this.typeOfTrade = typeOfTrade; 
	}
    

}
