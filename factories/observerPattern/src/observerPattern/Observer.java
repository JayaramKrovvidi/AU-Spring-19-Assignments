package observerPattern;

public interface Observer {
	
	//used by subject
	public void update();
	
	//attach with subject
	public void setSubject(Subject sub);
}