package grp.work;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private Customer customer;

    @BeforeEach
    void setUp()throws Exception {
        customer = new Customer("John Dave", 1);
    }

    @AfterEach
    void tearDown()throws Exception {
        customer = null;
    }

    @Test
    void testGetName() {
        assertEquals("John Dave", customer.getName());
    }

    @Test
    void testSetName() {
        customer.setName("Helen Paul");
        assertEquals("Helen Paul", customer.getName());
    }

    @Test
    void testGetId() {
        assertEquals(1, customer.getId());
    }

    @Test
    void testSetId() {
        customer.setId(3);
        assertEquals(3, customer.getId());
    }
}