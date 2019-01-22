package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@Column(name="book_id")
	public Integer book_id;
	
	@Column(name="book_name")
	public String book_name;
	
	@Column(name="book_author")
	public String book_author;
	
	public Book(int id, String name, String author)
	{
		this.book_id=id;
		this.book_name=name;
		this.book_author=author;
	}

	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	
	@Override
	public String toString()
	{
		return "ID:"+this.book_id+" Name:"+this.book_name+" Author:"+this.book_author;
	}

}
