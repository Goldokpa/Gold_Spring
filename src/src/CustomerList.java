package src;
import java.util.ArrayList;
import java.util.List;


public class CustomerList {
    private List<Customer> customersList;
    
    public CustomerList() {
        customersList = new ArrayList<Customer>();
    }
    
    public void addCustomer(Customer customer) {
    	customersList.add(customer);
    }
    
    public void removeCustomer(Customer customer) {
    	customersList.remove(customer);
    }

	public List<Customer> getCustomers() {
		return customersList;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		customersList = customers;
	}
	
}
