package com.neena.library.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Table(name = "BORROWED_BOOKS")
@Entity
public class BorrowedBook implements Serializable {
	public enum BORROWED_STATUS{
		RETURNED, 
		BORROWED, 
		LOST; 
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "BORROWED_BOOK_ID")
	private long id;

	@Column(name = "VERSION")
	private int version;

	@ManyToOne
	@JoinColumn(name = "BOOK_ID", nullable = false)
	private Book book;

	@ManyToOne
	@JoinColumn(name = "BORROWER_ID", nullable = false)
	private Borrower borrower;

	@Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
    @Column(name = "CREATED_ON",  updatable = false)
	private Date createdOn;
    
    @Temporal(value = TemporalType.TIMESTAMP)
    @UpdateTimestamp
	@Column(name = "LAST_UPDATED_ON")
	private Date updatedOn;

	@Column(name = "BORROWED_BOOK_QTY")
	private long borrowedBookQty;
	
	@Column(name = "BORROWED_BOOK_STATUS")
	@Enumerated(EnumType.STRING)
	private BORROWED_STATUS borrowedBookStatus; 
	
	
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
    
    
	public BorrowedBook() {
		// TODO Auto-generated constructor stub
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
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

	public long getBorrowedBookQty() {
		return borrowedBookQty;
	}

	public void setBorrowedBookQty(long borrowedBookQty) {
		this.borrowedBookQty = borrowedBookQty;
	}

	public BORROWED_STATUS getBorrowedBookStatus() {
		return borrowedBookStatus;
	}

	public void setBorrowedBookStatus(BORROWED_STATUS borrowedBookStatus) {
		this.borrowedBookStatus = borrowedBookStatus;
	}
	
	
	
}
