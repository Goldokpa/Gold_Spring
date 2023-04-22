package grp.work;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepotWorkerTest {
    // Define instance variables for use in the test methods
    private DepotWorker depotWorker;
    private ParcelClaim parcelClaim1;
    private ParcelClaim parcelClaim2;
    private ParcelList pList;
    private CustomerList cList;

    @BeforeEach
    void setUp() throws Exception {

        cList = new CustomerList();
        pList = new ParcelList();

        // add parcels
        pList.addParcel(new Parcel("C452", 4, 12, "5 x 7 x 9"));
        pList.addParcel(new Parcel("C242", 8, 5, "3 x 4 x 5"));
        pList.addParcel(new Parcel("X357", 5, 16, "10 x 14 x 9"));

        //add customers
        cList.addCustomer(new Customer("Jake", 1));
        cList.addCustomer(new Customer("Judy", 3));


        // Instantiate DepotWorker and ParcelClaim objects before each test case
        depotWorker = new DepotWorker(pList);

        // attach first customer to parcels
        String [] parcels1 = {"C452", "X357"};
        parcelClaim1 = new ParcelClaim(cList.getCustomers().get(0).getName(), parcels1);

        // attach second customer to parcels
        String [] parcels2 = {"C242"};
        parcelClaim2 = new ParcelClaim(cList.getCustomers().get(1).getName(), parcels2);
    }

    @AfterEach
    void tearDown() throws Exception {
        // Set instance variables to null after each test case
        depotWorker = null;
        parcelClaim1 = null;
        parcelClaim2 = null;
        pList = null;
        cList = null;
    }

    @org.junit.jupiter.api.Test
    void testDepotWorker() {
        //tested in the other methods eg testGetCollectionQueue since we were able to calculate the fee using the depot object we created in the setup
    }

    @org.junit.jupiter.api.Test
    void testGetCollectionQueue() {
        depotWorker.addParcelClaimToQueue(parcelClaim1);

        assertEquals(1, depotWorker.getCollectionQueue().size());
    }

    @org.junit.jupiter.api.Test
    void testAddParcelClaimToQueue() {
        //tested in testGetCollectionQueue()
    }

    @org.junit.jupiter.api.Test
    void testRemoveParcelClaimFromQueue() {
        depotWorker.addParcelClaimToQueue(parcelClaim2);
        depotWorker.removeParcelClaimFromQueue(parcelClaim2);

        assertEquals(0, depotWorker.getCollectionQueue().size());
    }

    @org.junit.jupiter.api.Test
    void testFindParcel() {
        assertTrue(depotWorker.findParcel("C59d1") == null);
    }

    @org.junit.jupiter.api.Test
    void testCalculateFee() throws Exception {
        Parcel parcel = new Parcel("C452", 1, 24, "4 x 1 x 2");
        double calculatedFee = depotWorker.calculateFee(parcel);

        assertEquals(15, calculatedFee);
    }

    @Test
    /**
     * Test that all customers aka parcelclaims are attended to
     */
    void testAttendToCustomer() {
        depotWorker.addParcelClaimToQueue(parcelClaim1);
        depotWorker.addParcelClaimToQueue(parcelClaim2);

        assertTrue(pList.getCollectedParcels().isEmpty());

        depotWorker.attendToCustomer(parcelClaim1);
        assertEquals(1, pList.getUncollectedParcels().size());

        depotWorker.attendToCustomer(parcelClaim2);
        assertTrue(pList.getUncollectedParcels().isEmpty());
    }

}
