package src;
import java.util.ArrayList;
//import java.util.List;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;


class CustomerList {
    private ArrayList<Customer> customers;
    
    public CustomerList() {
        setCustomers(new ArrayList<Customer>());
    }
    
    public void addCustomer(Customer customer) {
        getCustomers().add(customer);
    }
    
    public void removeCustomer(Customer customer) {
        getCustomers().remove(customer);
    }

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
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
