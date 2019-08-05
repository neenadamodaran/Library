package com.neena.library.dao;

import java.util.List;

import com.neena.library.model.Book;

public interface BookDAO {
	public List<Book> getBooks();

	public void addBook(Book book);

	public Book getBookById(Long id);

	public void updateBook(Book book);

	public void deleteBook(Long id);
}
