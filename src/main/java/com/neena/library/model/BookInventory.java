package com.neena.library.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "BOOK_INVENTORY")
public class BookInventory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "VERSION")
	private int version; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "BOOK_INVENTORY_ID")
	private long id; 
	
	@OneToOne(mappedBy = "bookInventory")
	private Book book; 
	
	@Column(name = "QUANTITY", nullable = false)
	private long quantity;
	
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
	public BookInventory() {
	
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

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	} 
	
	public void addBook(Book book){
		book.setBookInventory(this);
		this.setBook(book);
	}

}
