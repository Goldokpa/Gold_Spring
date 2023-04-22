package grp.work;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @org.junit.jupiter.api.Test
    void testParcel() {
        assertEquals(4, parcelSample.getParcelId().length());
    }

    @org.junit.jupiter.api.Test
    void testGetParcelId() {
        assertEquals("C499", parcelSample.getParcelId());
    }

    @org.junit.jupiter.api.Test
    void testSetParcelId() {
        parcelSample.setParcelId("C345");
        assertEquals("C345", parcelSample.getParcelId());
    }

    @org.junit.jupiter.api.Test
    void testGetNumberOfDaysInDepot() {
        assertEquals(6, parcelSample.getDaysInDepot());

    }

    @org.junit.jupiter.api.Test
    void testGetHeight() {
        assertEquals(6, parcelSample.getHeight());

    }

    @org.junit.jupiter.api.Test
    void testGetLength() {
        assertEquals(4, parcelSample.getLength());

    }

    @org.junit.jupiter.api.Test
    void testGetWidth() {
        assertEquals(5, parcelSample.getWidth());

    }

    @org.junit.jupiter.api.Test
    void testIsCollected() {
        assertFalse(parcelSample.isCollected());
    }

    @Test
    void testGetCollectionFee() {
        assertEquals(0, parcelSample.getCollectionFee());
    }


}
