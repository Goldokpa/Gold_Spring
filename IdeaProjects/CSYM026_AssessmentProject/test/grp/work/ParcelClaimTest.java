package grp.work;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParcelClaimTest {


    @BeforeEach
    void setUp() throws Exception {
    }


    @AfterEach
    void tearDown() throws Exception {
    }

    // Test the ParcelClaim constructor with a given customer name and array of parcel IDs
    @org.junit.jupiter.api.Test
    void testConstructor() {
        String customerName = "Aira Star";
        String[] parcelIds = {"C591", "C456"};

        // Create a new ParcelClaim object
        ParcelClaim parcelClaim = new ParcelClaim(customerName, parcelIds);

        // Verify that the constructor correctly sets the customer name, parcel IDs,
        assertEquals(customerName.trim(), parcelClaim.getCustomerName());
        assertArrayEquals(parcelIds, parcelClaim.getParcelIds());

    }

    // Test the getParcelIds() method
    @org.junit.jupiter.api.Test
    void testGetParcelIds() {
        // Set up test data
        String[] parcelIds = {"C452", "C242", "X357"};
        ParcelClaim parcelClaim = new ParcelClaim("John Dave", parcelIds);

        // Verify that the getParcelIds() method returns the correct array of parcel IDs
        assertArrayEquals(parcelIds, parcelClaim.getParcelIds());
    }

    // Test the setParcelIds() method
    @org.junit.jupiter.api.Test
    void testSetParcelIds() {
        // Set up test data
        String[] parcelIds = {"C452", "C242", "X357"};
        ParcelClaim parcelClaim = new ParcelClaim("John Dave", parcelIds);
        String[] newParcelIds = {"C502", "C131", "C121"};

        // Call the setParcelIds() method to set a new array of parcel IDs
        parcelClaim.setParcelIds(newParcelIds);

        // Verify that the setParcelIds() method correctly sets the new array of parcel IDs
        assertArrayEquals(newParcelIds, parcelClaim.getParcelIds());
    }

    // test the getCustomerName() method
    @org.junit.jupiter.api.Test
    void testGetCustomerName() {
        // Set up test data
        String customerName = "John Dave";
        String[] parcelIds = {"C452", "C242", "X357"};
        ParcelClaim parcelClaim = new ParcelClaim(customerName, parcelIds);

        // Verify that the getCustomerName() method returns the correct customer name
        assertEquals(customerName.trim(), parcelClaim.getCustomerName());
    }

    // test the setCustomerName() method
    @Test
    void testSetCustomerName() {
        // Set up test data
        String[] parcelIds = {"X203", "C118"};
        ParcelClaim parcelClaim = new ParcelClaim("Asiwaju Tinibu", parcelIds);
        String newCustomerName = "Jane Doe";

        // Calls the setCustomerName() method to set a new customer name
        parcelClaim.setCustomerName(newCustomerName);

        // Verify that the setCustomerName() method correctly sets the new customer name
        assertEquals(newCustomerName.trim(), parcelClaim.getCustomerName());
    }
}
