//Passenger Class which would be created allotted into Taxis

public class Passenger {


    public static enum DESTINATION {
        WHITEFIELD, SARJAPUR, KRPURAM, INDIRANAGAR, MGROAD, HEBBAL, JAYANAGAR, PEENYA, HSRLAYOUT, KORAMANGLA
    }
    public static final DESTINATION[] DESTINATION_VALUES = DESTINATION.values();

    private DESTINATION destination;
    private static int id;

    public Passenger(DESTINATION destination){
        this.destination = destination;
        id++;
    }
    public DESTINATION getDestination() {
        return this.destination;
    }
    public int getId() {
    	return id;
    }
}
