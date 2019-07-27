package com.neena.library.controller;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neena.library.manager.BookManager;
import com.neena.library.model.Book;

@Controller
public class BooksController {


	BookManager bookManager;

	@Inject
	public BooksController(BookManager bookManager) {
		// TODO Auto-generated constructor stub
		this.bookManager = bookManager;
	}

	@RequestMapping(value = { "/books" }, method = RequestMethod.GET)
	public String getBooks(Model model) {
		List<Book> books = bookManager.getBooks();
		model.addAttribute("books", books);
		return "books";
	}
}
