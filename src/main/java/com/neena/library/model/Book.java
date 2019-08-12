package com.neena.library.model;

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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BOOKS")
//@org.hibernate.annotations.DynamicInsert(value = true)//for generating insert statements at runtiem and not during statup and also exclude null proprties
//@org.hibernate.annotations.DynamicUpdate(value = true)//for generating insert statements at runtiem and not during statup and also exclude unmodified proprties
//@org.hibernate.annotations.Immutable - if a class is not update-able then adding this
//it avoids automatic dirty checking.
public class Book implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "BOOK_ID")
	private Long id;
	
	@Version
	@Column(name = "VERSION")
	private int version; 

	@Column(name = "BOOK_NAME" , nullable=false)
	private String bookName;

	@Column(name = "AUTHOR_NAME", nullable=false)
	private String authorName;
	
	@Column(name = "BOOK_VERSION", nullable=false)
	private String bookVersion;

	
	
	@Column(name = "PUBLICATION_DATE")
	
	private Date publicationDate; 
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
    @Column(name = "CREATED_ON", updatable = false)
	private Date createdOn;
    
    @Temporal(value = TemporalType.TIMESTAMP)
    @UpdateTimestamp
	@Column(name = "LAST_UPDATED_ON")
	private Date updatedOn;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "books")
	private Set<BookCategory> categories = new HashSet<>(); 
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy= "book", fetch=FetchType.EAGER)
	private Set<BorrowedBook> borrowDetails = new HashSet<>(); 
	
	//Shared Primary Key
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BOOK_INVENTORY_ID", nullable=false)
	private BookInventory bookInventory; 
	
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
    
	
	public Book() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	
	public String getBookVersion() {
		return bookVersion;
	}

	public void setBookVersion(String bookVersion) {
		this.bookVersion = bookVersion;
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

	public Set<BookCategory> getCategories() {
		return categories;
	}

	public void setCategories(Set<BookCategory> categories) {
		this.categories = categories;
	}
	
	public void addBookCategory(BookCategory bookCategory){
		bookCategory.getBooks().add(this); 
		this.categories.add(bookCategory); 
	}

	public Set<BorrowedBook> getBorrowDetails() {
		return borrowDetails;
	}

	public void setBorrowDetails(Set<BorrowedBook> borrowDetails) {
		this.borrowDetails = borrowDetails;
	}
	
	public void addBorrowedDetail(BorrowedBook borrowedBook){
		borrowedBook.setBook(this);
		this.borrowDetails.add(borrowedBook); 
		
	}

	public BookInventory getBookInventory() {
		return bookInventory;
	}
	
	public void setBookInventory(BookInventory bookInventory) {
		this.bookInventory = bookInventory;
	}
}
