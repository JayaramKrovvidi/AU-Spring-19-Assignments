import java.util.LinkedList;
import java.util.Random;

public class PassengerQueueRunnable implements Runnable {
    TaxiStand stand;
    LinkedList<Passenger> passengerQueue;
    int queueNumber=0;
    public PassengerQueueRunnable(LinkedList<Passenger> queue, TaxiStand l) {
        this.passengerQueue = queue;
        stand = l;
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ie) {

            }
            int pick = new Random().nextInt(Passenger.DESTINATION.values().length);
            Passenger p = new Passenger(Passenger.DESTINATION_VALUES[pick]);
            System.out.println("New passenger with destination " + p.getDestination() + " arrives. ID:" + p.getId());
            
            //Trying to allocate new Passenger to the taxi in the stand.
            //If not possible, add to the passenger queue.
            synchronized(stand)
            {
	            if(!stand.allocatePassenger(p)) {
	                System.out.println("No cab found for passenger. Adding to Queue..");
	                synchronized(passengerQueue)
	                {
	                	passengerQueue.add(p);
	                	System.out.println("Passeneger added to queue. Queue Length " + passengerQueue.size());
	                }
	            }
            }
        }
    }
}
