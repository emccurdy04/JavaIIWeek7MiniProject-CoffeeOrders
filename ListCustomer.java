package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customers")
public class ListCustomer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="fName")
	private String fName;
	@Column(name="lName")
	private String lName;
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	public ListCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ListCustomer(String fName, String lName, String phoneNumber) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getLName() {
		return fName;
	}

	public void setLastName(String lName) {
		this.lName = lName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String returnCustomerDetails( ) {
		return fName + " " + lName + " "+ phoneNumber;
	}

}
