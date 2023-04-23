package src;

import java.io.FileNotFoundException;

public class Test {
		
	public static void main(String[] args) throws FileNotFoundException {

//		Step 1: read both csv files
		try {
			DataHandler dh = new DataHandler("./parcels.csv", "./customers.csv");

			//now singleton? classes
			new CustomerList();
			new ParcelList();
			
			CollectionQueue queue = new CollectionQueue();
			
			//create customers and parcels and add them to their lists
			dh.importAllCustomers();
			dh.importAllParcels();
			
			//create customer claims/collection queue
			dh.createCollectionQueue(queue);
			
			//initialise a depot worker with the depot's list of parcels
			DepotWorker worker1 = new DepotWorker(queue);
			
			
			
			//create thread for worker to start attending to the queue
			new Thread(worker1).start();
			
			//create thread for customers joining the queue after worker has started attending to the queue
			new Thread(queue).start();		
			
		}
		
		catch (FileNotFoundException e) {
			System.out.println("Files may not exist");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
