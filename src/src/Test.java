package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.io.*;

public class Test {
		
	public static void main(String[] args) throws FileNotFoundException {

//		Step 1: read both csv files
		try {
			DataHandler dh = new DataHandler("./parcels.csv", "./customers.csv");

			CustomerList cList = new CustomerList();
			ParcelList pList = new ParcelList();
						
			dh.importAllCustomers(cList);
			dh.importAllParcels(pList);
			
			DepotWorker worker1 = new DepotWorker(pList);

			//create queue
			dh.createCollectionQueueForWorker("./customers.csv", worker1);
			
						
			for(ParcelClaim claim: worker1.getCollectionQueue()) {
				worker1.attendToCustomer(claim);
			}
			
			System.out.println("\n\nDone...");
			
			System.out.println("Number of collected parcels: " + pList.getCollectedParcels().size());
			System.out.println("Number of remaining parcels: " + pList.getUncollectedParcels().size());
			
	        PrintWriter writer = new PrintWriter("output.txt"); //correct dir. path
	        writer.print("Depot Worker results \n\n");
	        writer.append("Number of collected parcels: " + pList.getCollectedParcels().size() + "\n"); // appends to the file
	        writer.append("Number of remaining parcels: " + pList.getUncollectedParcels().size() + "\n");
	        
	        DecimalFormat dpFormatter = new DecimalFormat("0.00");
	        
	        double totalFees = 0;
	        writer.append("\nCollected Parcels - Collection Fee\n");
	        for(Parcel p: pList.getCollectedParcels()) {
	        	writer.append(p.getParcelId() + " - £" + dpFormatter.format(p.getCollectionFee()) + "\n");
	        	totalFees += p.getCollectionFee();
	        }
	        writer.append("\nUncollected Parcels\n");

	        for(Parcel p: pList.getUncollectedParcels()) {
	        	writer.append(p.getParcelId() + "\n");
	        }
	        
	        writer.append("\nTotal Collection Fee for the day: £" + dpFormatter.format(totalFees) + "\n");
	        
	        writer.close();
			
		}
		
		catch (FileNotFoundException e) {
			System.out.println("Files may not exist");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		
		
//		Step 2: for the first one, create a ParcelList and for every line of csv, create a Parcel  and add to the
//		uncollectedParcels field in the ParcelList

//		Step 3: for the second one, create a CustomerList class and for every line of csv, create a Customer,
//			create a ParcelClaim with the Customer object and the rest of the details, and add the ParcelClaim to the
//			collectionQueue attribute (static attribute so no need to instantiate a Depot_Worker)

//		Step 4: 
//			For every ParcelClaim object in the collectionQueue, run a method that:
//				a) finds the parcel to ensure it exists in the ParcelList (using the id from the object), returns the found parcel
//				b) calculates the collection fee based on the parcel details
//				c) processCollection which: 
//					1) adds the collection fee calculated to the parcel,
//					2) adds it to the collectedParcelList attribute of ParcelList,
//					3) removes it from the uncollectedParcelList, and
//					4) change the collected attribute to true
//				d) moves on to the next ParcelClaim object

//		Step 5: check the parcels left in the uncollectedParcelList, vs. the ones in the collectedParcelList,
//				convert the details of each one to a string, and append to a txt file,
//				include counts of each list, maybe total collection fees, etc

	}
	
}
