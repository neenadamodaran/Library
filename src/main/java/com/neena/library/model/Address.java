package com.neena.library.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	 /*@GeneratedValue(generator= "foreignKeyGenerator")
	@GenericGenerator(
		name = "foreignKeyGenerator",
		strategy = "foreign",
		parameters= @Parameter(name="property", value="borrower")
				
	)*/
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ADDRESS_ID")
	private int id;
	
	
    @Column(name = "ADDRESS_LINE_1")
	private String addressLine1;
	

    @Column(name = "ADDRESS_LINE_2")
	private String addressLine2;
	
	
    @Column(name = "CITY")
	private String city;
	
	
    @Column(name = "STATE")
	private String state;
	
	
    @Column(name = "POSTAL_CODE")
	private String postalCode;
    
    @Column(name = "COUNTRY")
	private String country;
    
    @Column(name = "VERSION")
	private int version; 
    
    @Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
    @Column(name = "CREATED_ON",  updatable = false)
	private Date createdOn;
    
    @Temporal(value = TemporalType.TIMESTAMP)
    @UpdateTimestamp
	@Column(name = "LAST_UPDATED_ON")
	private Date updatedOn;
    
    @OneToOne(mappedBy="address")
    private Borrower borrower;

    public Address(){
    	
    }
    
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public Date getUpdatedOn() {
		return updatedOn;
	}


	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}


	public Borrower getBorrower() {
		return borrower;
	}


	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	
	
    
    
}
