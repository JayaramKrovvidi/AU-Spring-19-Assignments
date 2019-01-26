package observerPattern;

public interface Subject {

	//register and unregister observers
	public void register(Observer obj);
	public void unregister(Observer obj);
	
	//notify observers
	public void notifyObservers();
	
	//get updates
	public Object getUpdate(Observer obj);
	
}