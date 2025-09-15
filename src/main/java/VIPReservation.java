public class VIPReservation extends Reservation {
    // Field tracks that VIP customers get free drinks. (always set to true)
    private boolean freeDrinks;

    // This stores the seating preference of the customer e.g Window or Inside.
    private String prioritySeatingPreference;

    // Constructor
    public VIPReservation(String customerName, String phoneNumber, int tableNumber,
                          int numberOfGuests, String prioritySeatingPreference)
    {
        super(customerName, phoneNumber, tableNumber, numberOfGuests);

        // VIP customers will always get free drinks.
        this.freeDrinks = true;

        // Set seating preference
        this.prioritySeatingPreference = prioritySeatingPreference;
    }

    // also does overiding oof the toString() method to include VIP details.
    @Override
    public String toString() {
        return super.toString() +
                "\nVIP: FreeDrinks " +
                (prioritySeatingPreference != null ? "| Priority: " +
                        prioritySeatingPreference : "");
    }
}

