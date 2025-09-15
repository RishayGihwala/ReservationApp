public class BarReservation extends Reservation  {
    /* Field to store which section the customer decides to reserve.
    Sections: A, B or C  */
    private String barSection;

    // Constructor
    public BarReservation(String customerName, String phoneNumber,
                          int tableNumber, int numberOfGuests, String barSection)
    {
        // Calls parent constructor
        super(customerName, phoneNumber, tableNumber, numberOfGuests);
        // Sets the specific section in the bar I have made 3 sections.
        this.barSection = barSection;
    }

    /* Overrides the toString() method to include details regarding the
       bar section. */
    @Override
    public String toString() {
        return super.toString() + "\nBar Section: " + barSection;
    }
}

