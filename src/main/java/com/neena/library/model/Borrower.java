package com.neena.library.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Table(name = "BORROWER")
@Entity
public class Borrower implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "BORROWER_ID")
	private Long id;
	
	@Column(name = "BORROWER_FIRST_NAME")
	private String borrowerFirstName; 
	
	
	@Column(name = "BORROWER_LAST_NAME")
	private String borrowerLastName; 

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="BORROWER_ADDRESS_ID", nullable = false)
    private Address address; 
	
	//setting the inverse part of the relationship
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},mappedBy= "borrower" , fetch=FetchType.EAGER)
	private Set<BorrowedBook> borrowedBooks = new HashSet<>();
	
	
	
	@Column(name = "VERSION")
	private int version; 
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
    @Column(name = "CREATED_ON", updatable = false)
	private Date createdOn;
    
    @Temporal(value = TemporalType.TIMESTAMP)
    @UpdateTimestamp
	@Column(name = "LAST_UPDATED_ON")
	private Date updatedOn;
	
    @PrePersist
    public void prePersist() {
        createdOn = new Date();
        //createdBy = LoggedUser.get();
    }
 
    @PreUpdate
    public void preUpdate() {
        updatedOn = new Date();
        //updatedBy = LoggedUser.get();
    }
    
	
	public Borrower() {
		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBorrowerFirstName() {
		return borrowerFirstName;
	}

	public void setBorrowerFirstName(String borrowerFirstName) {
		this.borrowerFirstName = borrowerFirstName;
	}

	public String getBorrowerLastName() {
		return borrowerLastName;
	}

	public void setBorrowerLastName(String borrowerLastName) {
		this.borrowerLastName = borrowerLastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		address.setBorrower(this);
		this.address = address;
	}

	public void addBorrowedBook(BorrowedBook borrowedBook){
		borrowedBook.setBorrower(this);
		borrowedBooks.add(borrowedBook);
	}

	public Set<BorrowedBook> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(Set<BorrowedBook> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
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
	
	
	
}
