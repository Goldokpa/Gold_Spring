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


//public void readCustomersFromCSV(String filePath) throws IOException {
//    BufferedReader br = new BufferedReader(new FileReader(filePath));
//    String line;
//    while ((line = br.readLine()) != null) {
//        String[] values = line.split(",");
//        String name = values[0];
//        int id = Integer.parseInt(values[1]);
//        Customer customer = new Customer(name, id);
//        addCustomer(customer);
//    }
//    br.close();
//}
}
