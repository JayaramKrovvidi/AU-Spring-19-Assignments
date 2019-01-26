package springer.model;

public class Book {
	private int bookId;
	private String bookName;
	private String authorName;
	private int bookPrice;
	private String bookDesc;
	
	public Book() {}
	
	public Book(int bookId, String bookName, String authorName, int bookPrice, String bookDesc) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookPrice = bookPrice;
		this.bookDesc = bookDesc;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
}
