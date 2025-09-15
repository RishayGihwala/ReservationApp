public class SpecialEventReservation extends Reservation {
    // Field to store the type of event.
    private String eventType;

    // Constructor
    public SpecialEventReservation(String customerName, String phoneNumber,
                                   int tableNumber, int numberOfGuests,
                                   String eventType)
    {

        super(customerName, phoneNumber, tableNumber, numberOfGuests);
        this.eventType = eventType; // Sets the special event
    }

    // will Override the toString method to include the event type.
    @Override
    public String toString() {
        return super.toString() + "\nEvent Type: " + eventType;
    }
}

