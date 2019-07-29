package com.neena.library.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.Date; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "BOOK_CATEGORY")
public class BookCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "BOOK_CATEGORY_ID")
	private Long id;

	@Column(name = "VERSION")
	private int version;

	@Column(name = "BOOK_CATEGORY_NAME", nullable=false)
	private String bookCategoryName;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
    @Column(name = "CREATED_ON",  updatable = false)
	private Date createdOn;
    
    @Temporal(value = TemporalType.TIMESTAMP)
    @UpdateTimestamp
	@Column(name = "LAST_UPDATED_ON")
	private Date updatedOn;

	@ManyToMany
	@JoinTable(name = "CATEGORY_BOOK", joinColumns = { @JoinColumn(name = "CATEGORY_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "BOOK_ID") }

	)
	private Set<Book> books = new HashSet<>();
	
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
    

	public BookCategory() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookCategoryName() {
		return bookCategoryName;
	}

	public void setBookCategoryName(String bookCategoryName) {
		this.bookCategoryName = bookCategoryName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
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
