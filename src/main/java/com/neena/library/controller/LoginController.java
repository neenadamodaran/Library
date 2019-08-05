package com.neena.library.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.neena.library.manager.BookManager;
import com.neena.library.model.Book;

@Controller
public class LoginController {
	
	BookManager bookManager;
	
	
	@Inject
    public LoginController(BookManager bookManager) {
		super();
		this.bookManager = bookManager;
	}

	@RequestMapping(value ={"/", "/login"}, method=RequestMethod.GET)
    public String login(@RequestParam(value="email", required=false, defaultValue="") String name, @RequestParam(value="password", required=false, defaultValue="") String password, Model model) {
       return "login";
    }
    
    @RequestMapping(value ={"/processLogin"}, method=RequestMethod.POST)
    public String processLogin(@RequestParam(value="email", required=false, defaultValue="") String email, @RequestParam(value="password", required=false, defaultValue="") String password, Model model) {
       if(StringUtils.isEmpty(email) || StringUtils.isEmpty(password) ){
    	   System.out.println("processed   " + email); 
    	   return "login"; 
       }
       else {
    	   List<Book> books = bookManager.getBooks();
   		model.addAttribute("books", books);
   		return "books";
       }
    	   
    }
}
