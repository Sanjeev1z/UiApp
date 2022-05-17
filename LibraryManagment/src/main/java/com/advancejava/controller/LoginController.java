package com.advancejava.controller;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.advancejava.model.Book;
import com.advancejava.service.BookService;
import com.advancejava.service.LoginService;

@Controller
public class LoginController {

	private String username;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private LoginService loginService;

	@Autowired
	BookService bookService;

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String Login(@RequestParam("username") String username,@RequestParam("password") String password, Model m) throws Exception {

		String uname = loginService.validateUser(username, password);
		if (uname != null) {
			m.addAttribute("uname", username);
			Book[] book = bookService.getBook();
			for(Book b : book) {
				System.out.println("AUthor is " + b.getAuthorName());			
			}
			m.addAttribute("bookArray", book);
			return "libraryPage.jsp";
		} 
		else {
			m.addAttribute("wrongUname", "Wrong login id or password");
			return "index.jsp";
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/logout")
	public String logout() {
		return "index.jsp";
	}
	
	
	
	@RequestMapping(value="/addBook",method=RequestMethod.POST)
	public String addBook(@RequestParam(value="bookId") int bookId,@RequestParam(value="bookName") String bookName
				,Model model,@RequestParam(value="author") String authorName,@RequestParam("date") String date) {
		
		Book book=new Book(bookId,bookName,authorName,date);
		System.out.println(book.getAuthorName());
		bookService.addBook(book);
		model.addAttribute("uname",username);
		Book[] b=bookService.getBook();
		model.addAttribute("bookArray",b);
		return "libraryPage.jsp";
	}
	
	
	@RequestMapping("/deleteBook")
	public String deleteBook(Model model,@RequestParam("bookCode") int bookCode) {
		bookService.deleteBook(bookCode);
		model.addAttribute("uname",username);
		Book[] book=bookService.getBook();
		model.addAttribute("bookArray",book);
		return "libraryPage.jsp";
	}
	
	@RequestMapping("/editBook")
	public String editBook( Model model,@RequestParam("bookname") String bookName,@RequestParam("author") String authorName,
			 @RequestParam("id") int bookId,@RequestParam("date") String date) {
		Book book=new Book(bookId,bookName,authorName,date);
		bookService.updateBook(book, bookId);
		model.addAttribute("uname",username);
		Book[] b=bookService.getBook();
		model.addAttribute("bookArray",b);
		return "libraryPage.jsp";
	}
	

}
