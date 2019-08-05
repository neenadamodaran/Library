package com.neena.library.manager;

import java.util.List;


import com.neena.library.model.Book;
public interface BookManager {
	
	public List <Book> getBooks();

	public void addBook(Book book);

	public void updateBook(Book book);

	public Book getBookById(Long id);

	public void deleteBookById(Long id);

}
