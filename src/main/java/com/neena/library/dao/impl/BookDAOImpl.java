package com.neena.library.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.neena.library.dao.BookDAO;
import com.neena.library.model.Book;

@Transactional
@Repository("BookDAO")
public class BookDAOImpl implements BookDAO {

	@PersistenceContext
	EntityManager entityManager;

	public List<Book> getBooks()  {

		
		List<Book> books = entityManager.createQuery("from Book b order by b.bookName")
				.getResultList();
		
		return books;
		
	}

}
