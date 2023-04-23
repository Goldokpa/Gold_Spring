package src;
import java.util.ArrayList;
import java.util.List;

//Singleton class? - Only need one instance since all workers will be working with the same parcel inventory
public class CustomerList {
    private static List<Customer> customersList;
    
    public CustomerList() {
        customersList = new ArrayList<Customer>();
    }
    
    public static void addCustomer(Customer customer) {
    	customersList.add(customer);
    }
    
    public static void removeCustomer(Customer customer) {
    	customersList.remove(customer);
    }

	public static List<Customer> getCustomers() {
		return customersList;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		customersList = customers;
	}
	
}
