package org.comit.sourse.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class User {
	private int 	iduser;
	private String 	firstname;
	private String 	lastname;
	private String 	username;
	private String 	password;
	private String 	email;  
	private String	boxtype; 
	private String  boxname;   
	private Date 	daterent;      
	private int 	parcel;    
   
	public User() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIduser() {
		return iduser;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getBoxtype() {
		return boxtype;
	}

	public String getBoxname() {
		return boxname;
	}

	public Date getDaterent() {
		return daterent;
	}

	public int getParcel() {
		return parcel;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBoxtype(String boxtype) {
		this.boxtype = boxtype;
	}

	public void setBoxname(String boxname) {
		this.boxname = boxname;
	}

	public void setDaterent(Date daterent) {
		this.daterent = daterent;
	}

	public void setParcel(int parcel) {
		this.parcel = parcel;
	}
}
