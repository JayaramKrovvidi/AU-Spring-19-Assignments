package hibernate;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class App {
	public static void main(String[] args) {
		System.out.println("Starting Hibernate");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		Shelf shelf = new Shelf(1);
		
		session.save(shelf);
		
		session.getTransaction().commit();
		
		Book book1 = new Book(1,"the alchemist","paulo coelho");
		Book book2 = new Book(2,"kite runner", "nicolas sparks");
		
		session.save(book1);
		session.save(book2);
		
		
		ArrayList<Book> booklist = new ArrayList<Book>();
		Criteria cr = session.createCriteria(Book.class);
		
		System.out.println("Displaying details of Book with ID 1");
	    cr.add(Restrictions.eq("book_id",1));
	    booklist = (ArrayList<Book>) cr.list();
	        
	    for(Book b: booklist)
	    {
	    	System.out.println(b.toString());
	    }
	    
	    Criteria cr2 = session.createCriteria(Shelf.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	    
	    ArrayList<Shelf> shelves = new ArrayList<Shelf>();
	    
	    System.out.println("Using Join: Printing all the books in shelf ID:1");
	    
	    shelves = (ArrayList<Shelf>) cr2.list();
	    
	    int i=0;
	    for(Shelf s : shelves)
	    {
	    	System.out.println("Shelf ID:"+s.getSh_id()+"Book ID:"+(!s.getBooks().isEmpty()?s.getBooks().get(i):""));
	    	i++;
	    }
	    
	}

}
