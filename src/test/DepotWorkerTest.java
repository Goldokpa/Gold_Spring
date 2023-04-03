package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.CustomerList;
import src.DataHandler;
import src.DepotWorker;
import src.Parcel;
import src.ParcelClaim;
import src.ParcelList;

class DepotWorkerTest {
    // Define instance variables for use in the test methods
    private DepotWorker depotWorker;
    private ParcelClaim parcelClaim1;
    private ParcelClaim parcelClaim2;
    private ParcelList pList;

	  @BeforeEach
	    void setUp() throws Exception {
		  DataHandler dh = new DataHandler("./parcels.csv", "./customers.csv");

			CustomerList cList = new CustomerList();
			pList = new ParcelList();
			
			//create customers and parcels and add them to their lists
			dh.importAllCustomers(cList);
			dh.importAllParcels(pList);
			
			//initialise a depot worker with the depot's list of parcels
			DepotWorker worker1 = new DepotWorker(pList);

			//create customer collection queue
			dh.createCollectionQueueForWorker("./customers.csv", worker1);
			

	        // Instantiate DepotWorker and ParcelClaim objects before each test case
	        depotWorker = new DepotWorker(pList);
	       String [] parcels1 = {"C452","C242", "X357"};
	        parcelClaim1 = new ParcelClaim("John Dave",parcels1);
	        String [] parcels2 = {"C502","C131","C121"};
	        parcelClaim2 = new ParcelClaim("Williams Bones", parcels2 );
	    }

	    @AfterEach
	    void tearDown() throws Exception {
	        // Set instance variables to null after each test case
	        depotWorker = null;
	        parcelClaim1 = null;
	        parcelClaim2 = null;
	    }

	@Test
	void testDepotWorker() {
//		depotWorker.getCollectionQueue();
		
		//tested in the other methods eg testGetCollectionQueue since we were able to calculate the fee using the depot object we created in the setup
	}

	@Test
	void testGetCollectionQueue() {
		depotWorker.addParcelClaimToQueue(parcelClaim1);
		depotWorker.addParcelClaimToQueue(parcelClaim2);
		depotWorker.removeParcelClaimFromQueue(parcelClaim2);
		int inQueue = depotWorker.getCollectionQueue().size();
		assertEquals(inQueue, 1);
	}

	@Test
	void testAddParcelClaimToQueue() {
		//tested in testGetCollectionQueue()
	}

	@Test
	void testRemoveParcelClaimFromQueue() {
		//tested in testGetCollectionQueue()
	}

	@Test
	void testFindParcel() {
		assertTrue(depotWorker.findParcel("C59d1")==null);
		
		
	}

	@Test
	void testCalculateCollectionFee() throws Exception {
		Parcel parcel = new Parcel("C452",1,24,"4 x 1 x 2");
		double fee = depotWorker.calculateCollectionFee(parcel);
		assertEquals(fee,15);
	}

	@Test
	void testAttendToCustomer() {
		depotWorker.attendToCustomer(parcelClaim1);
		assertFalse(pList.getCollectedParcels().isEmpty());
//		parcelClaim1.getParcelIds().
		//fail("Not yet implemented");
	}

}
