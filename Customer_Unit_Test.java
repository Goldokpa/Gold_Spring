package src;

import static org.junit.Assert.*;

import org.junit.Test;

public class Customer_Unit_Test {

	@Test
	public void testCustomer() {
        Customer customer = new Customer("John Dave", 1);
        assertEquals("John Dave", customer.getName());
        assertEquals(1, customer.getId());
    }

	@Test
	public void testGetName() {
        Customer customer = new Customer("Helen Paul", 2);
        assertEquals("Helen Paul", customer.getName());
    }

	@Test
	public void testSetName() {
        Customer customer = new Customer("John", 1);
        customer.setName("Joy Saint");
        assertEquals("Joy Saint", customer.getName());
    }

	@Test
	public void testGetId() {
	Customer customer = new Customer("Williams Bones", 3);
    assertEquals(3, customer.getId());
}
	

	@Test
	public void testSetId() {
        Customer customer = new Customer("John", 1);
        customer.setId(4);
        assertEquals(4, customer.getId());
    }

}
