import java.util.LinkedList;

public class TaxiQueueRunnable implements Runnable {

    private LinkedList<Taxi> taxiQueue;
    private TaxiStand taxiStand;

    public TaxiQueueRunnable(LinkedList<Taxi> q, TaxiStand l){
        taxiQueue = q;
        taxiStand = l;
    }
    
    //Creating a Taxi every 30sec and adding it to Taxi Queue
    @Override
    public void run() {
        System.out.println("Starting taxiQueue Thread...");
        while(true) 
        {
            try 
            {	
                Thread.sleep(30000);
            } 
            catch (InterruptedException ie) {}
            
            taxiQueue.add(new Taxi());
            
        }
    }
}
