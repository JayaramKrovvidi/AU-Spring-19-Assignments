import java.util.LinkedList;
import java.util.ListIterator;

public class TaxiStand{
    private int size = 5;
    private LinkedList<Taxi> taxiStand;
    private LinkedList<Taxi> taxiQueue;
    private LinkedList<Passenger> passengerQueue;

    public TaxiStand(int capacity, LinkedList<Taxi> q, LinkedList<Passenger> pq) {
        size = capacity;
        taxiQueue = q;
        passengerQueue = pq;
        taxiStand = new LinkedList<Taxi>();
        for(int i=0; i<size ; i++){
            taxiStand.add(new Taxi());
        }
        System.out.println("Creating a TaxiStand of size " + size);
    }

    //Adding a Taxi from the Taxi Queue when one leaves the taxi stand when full 
    public boolean addTaxi()
    {
        synchronized(taxiQueue)
        {
        	if(taxiQueue.isEmpty())
        	{
        		System.out.println("No Taxis available");
        		return false;
        	}
        	else
        	{
        		synchronized(taxiStand)
        		{
	        		taxiStand.add(taxiQueue.pop());
	        		System.out.println("Popping a Taxi from the Queue");
	        		processPassengerQueue();
	        		return true;
        		}
        	}
        }
    }

    public boolean isFull(){
        return (taxiStand.size()<size) ? false : true;
    }
    
    public boolean isEmpty() {
        return (taxiStand.size()==0) ? true : false;
    }

    //Checking the taxi stand for best option for passenger
    //If no taxi is found, add him into the queue
    public boolean allocatePassenger(Passenger p) {
        synchronized(taxiStand)
        {
        	boolean allocated = false;
        	
        	// Check for partially filled Taxi
        	
        	for(Taxi t : taxiStand )
        	{
        		if(!t.isFull() && !t.isEmpty() && t.getDestination()==p.getDestination())
        		{
        			allocated = t.allocatePassenger(p);
        			if(allocated) 
        			{
        				if(t.isFull())
        				{
        					taxiStand.remove(t);
        					while(!addTaxi())
        					{
        						System.out.println("Waiting for Taxi to be created");
        						try{ Thread.sleep(1000); } catch(InterruptedException e) {}
        					}
        				}
        				break;
        			}
        		}
        	}
        	
        	if(!allocated)
        	{
        		//Check for Empty Taxi
	        	for(Taxi t : taxiStand)
	        	{
	        		if(t.isEmpty())
	        		{
	        			allocated = t.allocatePassenger(p);
	        			if(allocated) break;
	        		}
	        	}
        	}
        	
        	return allocated;
        	
        }
    }
    
    //Trying to process passengers from the queue efficiently
    public void processPassengerQueue(){
        synchronized(passengerQueue)
        {
        	synchronized(taxiStand)
        	{
        		if(!passengerQueue.isEmpty())
        		{
					System.out.println("Starting to process passengerQueue with " + passengerQueue.size() + " passengers");
				    
					for(Passenger p : passengerQueue)
					{
						allocatePassenger(p);
					}
					
				    System.out.println("After processing passengerQueue " + passengerQueue.size() + " passengers remain in queue");
        		}
        	}
        }
    }

    //Current status of the Taxi Stand and Taxis in it
    public void printStatus() {
        ListIterator<Taxi> standIterator = taxiStand.listIterator();
        int position=0;
        while(standIterator.hasNext()) {
            Taxi taxi = standIterator.next();
            position++;
            System.out.println(position + ". Taxi to " + taxi.getDestination() + " passengers=" + taxi.getpassengerCount());
        }
    }
    
    //Main thread for Simulation
    public static void main(String[] args) {
        System.out.println("Starting simulaion...");
        LinkedList<Taxi> taxiQueue = new LinkedList<Taxi>();
        LinkedList<Passenger> passengerQueue = new LinkedList<Passenger>();
        TaxiStand stand = new TaxiStand(5, taxiQueue, passengerQueue);

        TaxiQueueRunnable taxicreator = new TaxiQueueRunnable(taxiQueue, stand);
        PassengerQueueRunnable passengerCreator = new PassengerQueueRunnable(passengerQueue, stand);
        
        Thread runTaxiQueue = new Thread(taxicreator, "Thread for TaxiQueueRunnable");
        Thread runPassengerQueue = new Thread(passengerCreator, "Thread for PassengerQueueRunnable");
        
        runTaxiQueue.start();
        runPassengerQueue.start();

    }
}
