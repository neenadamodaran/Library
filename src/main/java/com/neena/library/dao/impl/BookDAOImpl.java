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
import javax.persistence.Query;
import javax.sql.DataSource;
import javax.transaction.Transaction;


import org.apache.derby.jdbc.EmbeddedDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
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
	
	@Transactional(propagation=Propagation.REQUIRED , readOnly=true, isolation=Isolation.READ_COMMITTED)
	public List<Book> getBooks()  {
	List<Book> books = entityManager.createQuery("from Book b order by b.bookName")
				.getResultList();
		
		
		return books;
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	public void addBook(Book book) {
		entityManager.persist(book); 
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, isolation=Isolation.READ_COMMITTED)
	public Book getBookById(Long id) {
		// TODO Auto-generated method stub
		String hql = "from Book  s where s.id = :id";
		return (Book) entityManager.createQuery(hql).setParameter("id", id).getResultList().get(0); 
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	public void updateBook(Book book) {
		entityManager.merge(book);		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	public void deleteBook(Long id) {
		Query query = entityManager.createQuery("DELETE Book b WHERE id = :id");
		query.setParameter("id", id);
		query.executeUpdate();

		
	}
	
	

}
