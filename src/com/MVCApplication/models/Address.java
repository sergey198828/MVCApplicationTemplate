package com.MVCApplication.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Comparable<Address>{
	@Column(name="USERS_USER_ADDRESS_INDEX")
	int index;
	@Column(name="USERS_USER_ADDRESS_COUNTRY")
	String country;
	@Column(name="USERS_USER_ADDRESS_CITY")
	String city;
	@Column(name="USERS_USER_ADDRESS_LOCATION")
	String location;

	public Address() {
		
	}
	
	public Address(int index, String country, String city, String location) {
		super();
		this.index = index;
		this.country = country;
		this.city = city;
		this.location = location;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int compareTo(Address o) {
		if(this.index==o.index && this.city==o.city && this.country==o.country && this.location==o.location) return 0;
		else if(this.index<o.index)return -1;
		else return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (index != other.index)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [index=" + index + ", country=" + country + ", city=" + city + ", location=" + location + "]";
	}
	
}