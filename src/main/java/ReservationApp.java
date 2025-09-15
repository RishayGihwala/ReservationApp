import java.util.Scanner;

public class ReservationApp {

    // This represents rows and columns of tables. I used a 2d array
    Reservation[][] tables;
    // Scanner for user input
    private Scanner scanner;

    // Constructor initializes the seating layout
    public ReservationApp(int rows, int cols) {
        tables = new Reservation[rows][cols];
        scanner = new Scanner(System.in);
}

    /* Runs the main menu loop for my real-time booking system known as Layout.
           It provides users with various options to choose from when interacting
           with the app. */
    public void run() {
        while (true) {
            System.out.println("\n---- WELCOME TO LAYOUT A RESTAURANT BOOKING SYSTEM ----");
            System.out.println("1) View The Seating Layout");
            System.out.println("2) Make Reservation");
            System.out.println("3) Show All Reservations");
            System.out.println("4) Exit");
            System. out.print("Enter choice: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    displayTables();
                    break;
                case "2":
                    makeReservation();
                    break;
                case "3":
                    printReservations();
                    break;
                case "4":
                    System. out.println("Exiting. Goodbye!");
                    return;
                default:
                    System. out.println("Invalid choice. Try again.");
            }
        }
    }

    /* This shows the seating layout at the restaurant. Once you book a table, it
       will be marked with an x, and all available tables are represented as O. */
    private void displayTables() {
        System.out.println("\nSeating Layout (O = Free, X = Reserved):");
        for (int i = 0; i < tables.length; i++) {
            for (int j = 0; j < tables[i].length; j++) {
                System.out.print(tables[i][j] == null ? "[O] " : "[X] ");
            }
            System.out.println();
        }
    }

    // The user must enter at least their first and last name.
    private String getValidName(String prompt) {
        while (true) {
            System.out.print(prompt);
            String fullname = scanner.nextLine().trim();
            if (fullname.matches("^[A-Za-z]+\\s+[A-Za-z]+$")) {
                return fullname;
            }
            System. out.println("Invalid name. Please enter your first and last name.");
        }
    }

    /* Makes sure that the user enters their phone number in the South African
       format. I have implemented a regex to ensure this. */
    private String getValidPhoneNumber(String prompt) {
        while (true) {
            System.out.print(prompt);
            String phonenumber = scanner.nextLine().trim();
            if (phonenumber.matches("^\\+27\\d{9}$")) return phonenumber;
            System.out.println("Invalid phone. Must be in format +27XXXXXXXXX");
        }
    }

    /* Helper method used for guest number, row and column number when booking
       a table. */
    private int getValidInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.matches("\\d+")) return Integer.parseInt(input);
            System. out.println("Invalid number, try again.");
        }
    }

    /*
      - Handles Reservation Process
      - Collects all relevant details of the customer
      - Offers different packages ( Seating Preferences )
    */
    private void makeReservation() {
        String fullname = getValidName("Enter full name (First and Last): ");
        String phonenumber = getValidPhoneNumber("Enter phone number (+27XXXXXXXXX): ");
        int guests = getValidInt("Enter number of guests: ");
        int row = getValidInt("Enter row number (0-" + (tables.length - 1) + "): ");
        int col = getValidInt("Enter column number (0-" + (tables[0].length - 1) + "): ");

        if (tables[row][col] != null) {
            System. out.println("Table already reserved!");
            return;
        }

        System.out.println("Select reservation type:");
        System.out.println("1) Standard");
        System.out.println("2) VIP");
        System.out.println("3) Bar Reservation");
        System.out.println("4) Special Event");
        System.out.print("Choice: ");
        String type = scanner.nextLine().trim();

        Reservation res;
        switch (type) {
            case "2":  // VIP ( Sunset View )
                res = new VIPReservation(fullname, phonenumber,
                        row * tables[0].length +
                                col, guests, "Window (Sunset)");
                break;

            case "3":  // Bar Reservation
                System.out.print("Choose bar section (A/B/C): ");
                String section = scanner.nextLine();
                res = new BarReservation(fullname, phonenumber,
                        row * tables[0].length +
                                col, guests, section);
                break;

            case "4":  // Special Event eg: Birthdays
                System.out.print("Event Type: ");
                String event = scanner.nextLine();
                res = new SpecialEventReservation(fullname, phonenumber,
                        row * tables[0].length +
                                col, guests, event);
                break;

            default: { // Standard Reservation
                System. out.print("Seating Preference (Inside/Outside): ");
                String pref = scanner.nextLine();
                res = new Reservation(fullname, phonenumber,
                        row * tables[0].length +
                                col, guests);
                res.setSeatingPreference(pref);
                break;
            }
        }

        tables[row][col] = res;
        System.out.println("\nReservation successful!");
        System.out.println(res);
    }

    /* This will provide all the reservations that are currently stored in
       tables [][]. */
    private void printReservations() {
        System.out.println("\n---- All Reservations ----");
        for (int i = 0; i < tables.length; i++) {
            for (int j = 0; j < tables[i].length; j++) {
                if (tables[i][j] != null) {
                    System. out.println("Table [" + i + "][" + j + "]");
                    System.out.println(tables[i][j]);
                    System.out.println("--------------------");
                }
            }
        }
    }
}