import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReservationAppTest {

    @Test
     public void testTablesStartEmpty() {
        ReservationApp app = new ReservationApp(2, 2);
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    assertNull(app.tables[i][j], "Tables should be empty to start off.");
                }
            }
        }

        @Test
        public void testAddStandardReservation() {
            ReservationApp app = new ReservationApp(2, 2);
            Reservation res = new Reservation("Rishay Gihwala", "+27813148181", 0, 2);
            res.setSeatingPreference("Inside");
            app.tables[0][0] = res;

            assertNotNull(app.tables[0][0], "Reservation should be added now.");
            assertEquals("Rishay Gihwala", app.tables[0][0].getCustomerName());
            assertEquals("Inside", app.tables[0][0].getSeatingPreference());
        }

        @Test
        public void testAddVIPReservation() {
            ReservationApp app = new ReservationApp(2, 2);
            VIPReservation vip = new VIPReservation("Cristiano Ronaldo", "+27846674553", 1, 4, "Window");
            app.tables[1][1] = vip;

            assertNotNull(app.tables[1][1]);
            assertTrue(app.tables[1][1] instanceof VIPReservation, "Should be a VIPReservation");
            assertEquals("Cristiano Ronaldo", app.tables[1][1].getCustomerName());
        }

        @Test
        public void testAddBarReservation() {
            ReservationApp app = new ReservationApp(2, 2);
            BarReservation bar = new BarReservation("Virat Kohli", "+27837654221", 0, 3, "B");
            app.tables[1][0] = bar;

            assertNotNull(app.tables[1][0]);
            assertTrue(app.tables[1][0] instanceof BarReservation, "Should be a BarReservation");
            assertEquals("B", ((BarReservation) app.tables[1][0]).toString().contains("Bar Section: B") ? "B" : null);
        }

        @Test
        public void testAddSpecialEventReservation() {
            ReservationApp app = new ReservationApp(2, 2);
            SpecialEventReservation special = new SpecialEventReservation(
                    "David Goggins", "+27412432119", 0, 6, "Birthday Party");
            app.tables[0][1] = special;

            assertNotNull(app.tables[0][1]);
            assertTrue(app.tables[0][1] instanceof SpecialEventReservation, "Should be a SpecialEventReservation");
            assertEquals("David Goggins", app.tables[0][1].getCustomerName());
            assertEquals(6, app.tables[0][1].getNumberOfGuests());
        }
    }

