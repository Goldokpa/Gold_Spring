package src;
import java.util.ArrayList;
import java.util.List;

//Singleton class - Only need one instance since all workers will be working with the same parcel inventory
public class CustomerList {
    private static List<Customer> customersList;
    
    private static CustomerList instance = null; //the singleton instance for the class

    // Constructor to create a new empty list of customers, private so it cannot be accessed outside
    private CustomerList() {
        customersList = new ArrayList<Customer>();
    }
    
    // ensures only one instance of CustomerList gets created throughout the program
    public static CustomerList getInstance() {
       if (instance == null) {
          instance = new CustomerList();
       }
       return instance;
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
