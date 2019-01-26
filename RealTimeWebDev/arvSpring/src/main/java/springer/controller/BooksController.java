package springer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springer.dao.BookDAO;
import springer.model.Book;
import springer.model.Checkout;

@RestController
public class BooksController {
	
	@Autowired
	BookDAO bdao;
	
	@RequestMapping(value = "/books" , method = RequestMethod.GET)
	public List<Book> getAllBooks()
	{
		return bdao.all();
	}
	
	@RequestMapping(value = "books/get/{bookId}", method = RequestMethod.GET)
	public Book getOne(@PathVariable("bookId") Integer bookId)
	{
		return bdao.byId(bookId);
		
	}
	
	@RequestMapping(value="/books/post",method = RequestMethod.POST,consumes="application/json")
	public Book create(@RequestBody Book bookToCreate) {
		return bdao.create(bookToCreate);
	}
	
	@RequestMapping(value="/addcart",method=RequestMethod.POST,consumes="application/json")
	public void addToCart(@RequestBody Checkout check) {
		System.out.println(check.getId()+" "+check.getName());
		 bdao.addCheckout(check.getId());
	}
	
	@RequestMapping(value="/getcart",produces="application/json")
	public List<Checkout> getToCart() {
		 return bdao.checkout();
	}
}
