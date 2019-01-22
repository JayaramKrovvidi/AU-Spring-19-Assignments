package hibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="shelf")
public class Shelf {
	@Id
	@Column(name="sh_id")
	public Integer sh_id;
	
	@Column(name="book_id")
	public Integer book_id;
	
	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	@OneToMany(mappedBy = "book_id", fetch = FetchType.EAGER)
	public List<Book> books;
	
	public Shelf() {}
	
	public Shelf(int id)
	{
		this.sh_id=id;
	}

	public Integer getSh_id() {
		return sh_id;
	}

	public void setSh_id(Integer sh_id) {
		this.sh_id = sh_id;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}
