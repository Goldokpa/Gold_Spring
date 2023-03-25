
package src;

//import java.io.IOException;

public class Main {
	
	 public static void main(String[] args) {
	        Customer c1 = new Customer("John", 14);
	        Customer c2 = new Customer("Jane", 56);
	        
	        CustomerList list = new CustomerList();
	        list.addCustomer(c1);
	        list.addCustomer(c2);
	        list.removeCustomer(c2);
	        
	        System.out.println("Customers:");
	        for (Customer c : list.getCustomers()) {
	            System.out.println(c.getName() + " - " + c.getId());
	        }
	    }
		
	}



//public static void main(String[] args) throws IOException {
//    CustomerList list = new CustomerList();
//    list.readCustomersFromCSV("customers.txt");
//    
//    System.out.println("Customers:");
//    for (Customer c : list.getCustomers()) {
//        System.out.println(c.getName() + " - " + c.getId());
//    }
//}
