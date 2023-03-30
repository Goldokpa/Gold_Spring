package src;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CustomerList_Unit_Test {
							

	@Test
	public void testAddCustomer() {
        CustomerList customerList = new CustomerList();
        Customer customer = new Customer("John Dave", 1);
        customerList.addCustomer(customer);
        assertTrue(customerList.getCustomers().contains(customer));
    }

	@Test
	public void testRemoveCustomer() {
        CustomerList customerList = new CustomerList();
        Customer customer1 = new Customer("John Dave", 1);
        Customer customer2 = new Customer("Helen Paul", 2);
        customerList.addCustomer(customer1);
        customerList.addCustomer(customer2);
        customerList.removeCustomer(customer2);
        assertFalse(customerList.getCustomers().contains(customer2));
    }

	@Test
	public void testGetCustomers() {
        CustomerList customerList = new CustomerList();
        Customer customer1 = new Customer("John", 1);
        Customer customer2 = new Customer("Helen Paul", 2);
        customerList.addCustomer(customer1);
        customerList.addCustomer(customer2);
        assertEquals(2, customerList.getCustomers().size());
        assertTrue(customerList.getCustomers().contains(customer1));
        assertTrue(customerList.getCustomers().contains(customer2));
    }

	@Test
	public void testSetCustomers() {
        CustomerList customerList = new CustomerList();
        Customer customer1 = new Customer("John", 1);
        Customer customer2 = new Customer("Helen Paul", 2);
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customerList.setCustomers(customers);
        assertEquals(2, customerList.getCustomers().size());
        assertTrue(customerList.getCustomers().contains(customer1));
        assertTrue(customerList.getCustomers().contains(customer2));
    }

}
