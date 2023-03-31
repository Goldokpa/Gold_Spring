package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Parcel;
import src.ParcelList;

class ParcelListTest {
	private ParcelList pList;
	private Parcel p1;
	private Parcel p2;

	@BeforeEach
	void setUp() throws Exception {
		pList = new ParcelList();
		p1 = new Parcel("C499", 6, 12, "4 x 5 x 6");
		p2 = new Parcel("C234", 6, 12, "4 x 5 x 6");
	}

	@AfterEach
	void tearDown() throws Exception {
		p2 = null;
		p1 = null;
		pList = null;
	}
	

	@Test
	void testAddParcel() {
		assertFalse(pList.getUncollectedParcels().contains(p2));
		
		pList.addParcel(p1);
		pList.addParcel(p2);
		assertTrue(pList.getUncollectedParcels().contains(p2));
		
	}

	@Test
	void testGetUncollectedParcels() {
		pList.addParcel(p1);
		pList.addParcel(p2);
		
		assertEquals(2, pList.getUncollectedParcels().size());
	}

	@Test
	void testGetCollectedParcels() {
		pList.addParcel(p1);
		pList.addParcel(p2);
		
		assertEquals(0, pList.getCollectedParcels().size());
	}

	@Test
	void testAddParcelToCollectedList() {
		pList.addParcel(p1);
		pList.addParcel(p2);
		
		assertTrue(pList.getUncollectedParcels().contains(p1));
		assertTrue(pList.getUncollectedParcels().contains(p2));
	}

	@Test
	void testRemoveParcelFromUnCollectedList() {
		pList.addParcel(p1);
		
		assertTrue(pList.getUncollectedParcels().contains(p1));
		pList.removeParcelFromUnCollectedList(p1);
		assertFalse(pList.getUncollectedParcels().contains(p1));
	}

}
