package com.neena.library.manager.impl;

import java.util.List;

import javax.inject.Inject;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neena.library.dao.BookDAO;
import com.neena.library.manager.BookManager;
import com.neena.library.model.Book;

@Service
@Transactional
public class BookManagerImpl implements BookManager {
	
	
	BookDAO bookDAO; 
	
	@Inject
	public BookManagerImpl(BookDAO bookDAO) {
		super();
		this.bookDAO = bookDAO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Book> getBooks() {
		
		return bookDAO.getBooks(); 
	}
}
