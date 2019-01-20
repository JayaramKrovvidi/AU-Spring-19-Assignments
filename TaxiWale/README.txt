synchronized blocks are used where applicable to prevent Race Conditions

Individual classes and their functionalities are listed below:

Passenger.java: 
	Class which would be created allotted into Taxis.

PassengerQueueRunnable.java:
	Trying to allocate new Passenger to the taxi in the stand.
            	If not possible, add to the passenger queue.
	
Taxi.java:
	Class which has current capacity and Destination as attributes.
	Created and added to the Taxi Queue.

TaxiQueueRunnable.java:
	Creating a Taxi every 30sec and adding it to Taxi Queue

TaxiStand.java:
	Main Class which runs the Taxi Stand and has 5 Taxis filled initially.
	Adding a Taxi from the Taxi Queue when one leaves the taxi stand when full.
	Checking the taxi stand for best option for passenger.
    	If no taxi is found, add him into the queue.
		- Check for partially filled Taxi.
		- Check for Empty Taxi before adding and set its destination.
	Trying to process passengers from the queue efficiently when new Taxi is added in the stand.
	Getting the current status of the Taxi Stand and Taxis in it.