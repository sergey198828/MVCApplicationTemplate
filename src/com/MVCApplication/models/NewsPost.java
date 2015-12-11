package com.MVCApplication.models;

import javax.persistence.Entity;

@Entity
public class NewsPost extends Post {

	NewsAgency agency;

	public NewsAgency getAgency() {
		return agency;
	}

	public void setAgency(NewsAgency agency) {
		this.agency = agency;
	} 
	

}
