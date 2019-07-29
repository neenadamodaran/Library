package com.neena.library.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transaction;


import org.apache.derby.jdbc.EmbeddedDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neena.library.dao.BookDAO;
import com.neena.library.model.Address;
import com.neena.library.model.Book;
import com.neena.library.model.BookCategory;
import com.neena.library.model.BookInventory;
import com.neena.library.model.BorrowedBook;
import com.neena.library.model.BorrowedBook.BORROWED_STATUS;
import com.neena.library.model.Borrower;

@Transactional
@Repository("BookDAO")
public class BookDAOImpl implements BookDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Book> getBooks()  {
		
		
		/*try {
			InitialContext ic = new InitialContext();
			EmbeddedDataSource myDS = (EmbeddedDataSource)ic.lookup("java:comp/env/jdbc/librarydb");
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	    
	    */
		//EntityTransaction tx = entityManager.getTransaction(); 
		//tx.begin();
		
		BookCategory bookCategory = new BookCategory(); 
		bookCategory.setBookCategoryName("ROMANCE");
		
		Book book = new Book();
		book.setAuthorName("book");
		book.setBookName("book name");
		book.setBookVersion("wew");
		
		BookInventory bookInventory = new BookInventory();
		bookInventory.setQuantity(1);
		bookInventory.addBook(book);
		
		
		entityManager.persist(book);
		
		Borrower borrower = new Borrower();
		Address address = new Address(); 
		address.setAddressLine1("CLarita Bernhard Strasse");
		address.setAddressLine2("10");
		address.setCity("Munich");
		address.setCountry("Germany");
		address.setPostalCode("81249");
		address.setState("Bavaria");
		address.setBorrower(borrower);
		
		borrower.setBorrowerFirstName("Aashish");
		borrower.setBorrowerLastName("Amrute"); 
		borrower.setAddress(address);
		
		entityManager.persist(borrower);

		book.addBookCategory(bookCategory);
		entityManager.persist(book);
		
		BorrowedBook borrowedBook = new BorrowedBook(); 
		borrowedBook.setBook(book);
		borrowedBook.setBorrowedBookQty(1);
		borrowedBook.setBorrower(borrower);
		borrowedBook.setBorrowedBookStatus(BORROWED_STATUS.BORROWED);
		book.addBorrowedDetail(borrowedBook);
		borrower.addBorrowedBook(borrowedBook);
		
		entityManager.persist(borrowedBook);
		entityManager.persist(book);
		entityManager.persist(borrowedBook);
		//tx.commit();
		List<Book> books = entityManager.createQuery("from Book b order by b.bookName")
				.getResultList();
		
		return books;
		
	}

}
