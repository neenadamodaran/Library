package com.neena.library.manager.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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

	public List<Book> getBooks() {
		return bookDAO.getBooks(); 
	}
}
