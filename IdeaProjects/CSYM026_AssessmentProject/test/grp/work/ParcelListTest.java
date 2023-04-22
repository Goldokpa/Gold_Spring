package grp.work;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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


    @org.junit.jupiter.api.Test
    void testAddParcel() {
        assertFalse(pList.getUncollectedParcels().contains(p2));

        pList.addParcel(p1);
        pList.addParcel(p2);
        assertTrue(pList.getUncollectedParcels().contains(p2));

    }

    @org.junit.jupiter.api.Test
    void testGetUncollectedParcels() {
        pList.addParcel(p1);
        pList.addParcel(p2);

        assertEquals(2, pList.getUncollectedParcels().size());
    }

    @org.junit.jupiter.api.Test
    void testGetCollectedParcels() {
        pList.addParcel(p1);
        pList.addParcel(p2);

        assertEquals(0, pList.getCollectedParcels().size());
    }

    @org.junit.jupiter.api.Test
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
