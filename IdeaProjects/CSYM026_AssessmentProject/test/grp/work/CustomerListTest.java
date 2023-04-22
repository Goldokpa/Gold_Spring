package grp.work;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerListTest {
    private CustomerList customerList;
    private Customer c1;
    private Customer c2;

    @BeforeEach
    void setUp()throws Exception {
        customerList = new CustomerList();
        c1 = new Customer("John Dave", 1);
        c2 = new Customer("Helen Paul", 2);
    }

    @AfterEach
    void tearDown()throws Exception {
        customerList = null;
        c1 = null;
        c2 = null;
    }

    @org.junit.jupiter.api.Test
    void testAddCustomer() {
        customerList.addCustomer(c1);
        assertEquals(1, customerList.getCustomers().size());
        assertTrue(customerList.getCustomers().contains(c1));

    }

    @org.junit.jupiter.api.Test
    void testRemoveCustomer() {
        customerList.addCustomer(c2);
        assertTrue(customerList.getCustomers().contains(c2));
        customerList.removeCustomer(c2);
        assertFalse(customerList.getCustomers().contains(c2));
    }

    @org.junit.jupiter.api.Test
    void testGetCustomers() {
        customerList.addCustomer(c1);
        customerList.addCustomer(c2);

        List<Customer> customers = customerList.getCustomers();
        assertEquals(2, customers.size());
        assertTrue(customers.contains(c1));
        assertTrue(customers.contains(c2));
    }

    @Test
    void testSetCustomers() {
        ArrayList<Customer> newCustomers = new ArrayList<>();
        newCustomers.add(c1);
        newCustomers.add(c2);

        customerList.setCustomers(newCustomers);
        assertEquals(2, customerList.getCustomers().size());
        assertTrue(customerList.getCustomers().contains(c1));
        assertTrue(customerList.getCustomers().contains(c2));
    }
}