public class Reservation {
    // Fields
    private String customerName;
    private String phoneNumber;
    private int tableNumber;
    private int numberOfGuests;
    private String seatingPreference;

    // Constructor
    public Reservation(String customerName, String phoneNumber, int tableNumber,
                       int numberOfGuests) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.tableNumber = tableNumber;
        this.numberOfGuests = numberOfGuests;
        this.seatingPreference = null;
    }

    //------------------------ GETTERS -------------------------------//

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public String getSeatingPreference() {
        return seatingPreference;
    }

    //------------------------ SETTERS ------------------------------//

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setSeatingPreference(String seatingPreference) {
        this.seatingPreference = seatingPreference;
    }

    /* Overrides the default Object.toString() method to display important
       informatuon contained in the String base. */
    @Override
    public String toString() {
        String base = "Customer: " + customerName +
                "\nPhone: " + phoneNumber +
                "\nTable: " + tableNumber +
                "\nGuests: " + numberOfGuests;
        if (seatingPreference != null) {
            base += "\nSeating: " + seatingPreference;
        }
        return base;
    }
}