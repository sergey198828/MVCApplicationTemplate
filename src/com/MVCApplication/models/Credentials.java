package com.MVCApplication.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Credentials{
	@Column(name="USERS_USER_CREDENTIALS_NAME")
	String name;
	@Column(name="USERS_USER_CREDENTIALS_SURNAME")
	String surname;
	@Column(name="USERS_USER_CREDENTIALS_BIRTH")
	String birth;
	@Column(name="USERS_USER_CREDENTIALS_NATIONALITY")
	String nationality;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credentials other = (Credentials) obj;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Credentials [name=" + name + ", surname=" + surname + ", birth=" + birth + ", nationality="
				+ nationality + "]";
	}
	
	
}