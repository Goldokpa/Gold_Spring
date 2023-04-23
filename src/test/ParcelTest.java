package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Parcel;

class ParcelTest {
	private Parcel parcelSample;

	@BeforeEach
	void setUp() throws Exception {
		parcelSample = new Parcel("C499", 6, 12, "4 x 5 x 6");
	}

	@AfterEach
	void tearDown() throws Exception {
		parcelSample = null;
	}

	@Test
	void testParcel() {
		assertEquals(4, parcelSample.getParcelId().length());		
	}

	@Test
	void testGetParcelId() {
		assertEquals("C499", parcelSample.getParcelId());
	}
	
	@Test
	void testSetParcelId() {
		parcelSample.setParcelId("C345");
		assertEquals("C345", parcelSample.getParcelId());	
	}

	@Test
	void testGetNumberOfDaysInDepot() {
		assertEquals(6, parcelSample.getDaysInDepot());

	}
	
	@Test
	void testGetHeight() {
		assertEquals(6, parcelSample.getHeight());

	}
	
	@Test
	void testGetLength() {
		assertEquals(4, parcelSample.getLength());

	}
	
	@Test
	void testGetWidth() {
		assertEquals(5, parcelSample.getWidth());

	}

	@Test
	void testIsCollected() {
		assertFalse(parcelSample.isCollected());
	}

	@Test
	void testGetCollectionFee() {
		assertEquals(0, parcelSample.getCollectionFee());
	}


}
