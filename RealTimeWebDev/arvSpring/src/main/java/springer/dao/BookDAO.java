package springer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import springer.model.Book;
import springer.model.Checkout;

@Repository
public class BookDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Book> all()
	{
		return jdbcTemplate.query("select * from book", (rs,i) -> {
			return new Book(rs.getInt("bookId"),rs.getString("bookName"), rs.getString("authorName"), rs.getInt("bookPrice"), rs.getString("bookDesc"));
		});
	}
	
	public Book byId(int id)
	{
		List<Book> books = jdbcTemplate.query("select * from book where bookId="+id, (rs,i) -> {
			return new Book(rs.getInt("bookId"),rs.getString("bookName"), rs.getString("authorName"), rs.getInt("bookPrice"), rs.getString("bookDesc"));
		});
		
		return books.get(0);
		
	}
	
	public Book create(Book book) {
		jdbcTemplate.update("insert into book values(?,?,?,?,?)",book.getBookId(),book.getBookName(),book.getAuthorName(),book.getBookPrice(),
				book.getBookDesc());
		return book;
	}
	
	public void addCheckout(int id){

		List<Book> books =  jdbcTemplate.query("select * from book where bookId="+ id, (rs,i)->{
			return new Book(rs.getInt(4),rs.getString(2),rs.getString(3),rs.getInt(1),rs.getString(5));
		});
		
		jdbcTemplate.update("insert into checkout values("+ id +",'" +books.get(0).getBookName() + "')");
	}
	
	public List<Checkout> checkout(){
		List<Checkout> checkoutList =  jdbcTemplate.query("select * from checkout ", (rs,i)->{
			return new Checkout(rs.getInt(1),rs.getString(2));
		});
		return checkoutList;
	}
}
