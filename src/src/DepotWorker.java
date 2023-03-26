package src;

import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class DepotWorker {
	private static List<ParcelClaim> collectionQueue;
	
	public static void main(String[] args) throws FileNotFoundException {

//		Step 1: read both csv files
		try {
			DataHandler da = new DataHandler("./sample_p.csv", "./sample_c.csv");

			CustomerList cList = new CustomerList();
			da.importAllCustomers(cList);
			
			for(Customer c: cList.getCustomers()) {
				System.out.println(c.getName());
			}
			//create parcels and parcelList
			
			collectionQueue = new ArrayList<ParcelClaim>();
			
			//create queue
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
//					1) creates a CollectedParcel with the parcel details AND collection fee calculated,
//					2) adds the CollectedParcel to the collectedParcelList attribute of ParcelList, and
//					3) removes the Parcel from the uncollectedParcelList
//				d) moves on to the next ParcelClaim object

//		Step 5: check the parcels left in the uncollectedParcelList, vs. the ones in the collectedParcelList,
//				convert the details of each one to a string, and append to a txt file,
//				include counts of each list, maybe total collection fees, etc

	}
	
	
	public List<ParcelClaim> getCollectionQueue() {
		return collectionQueue;
	}
	
	public void addParcelClaimToQueue(ParcelClaim p) {
		collectionQueue.add(p);
	}
	
	public void removeParcelClaimFromQueue(ParcelClaim p) {
		collectionQueue.remove(p);
	}

	private Parcel findParcel(String parcelId) {
		return new Parcel();
	}
	
	private double calculateCollectionFee(Parcel p) {
		double collectionFee = 0;
		
		
		
		return collectionFee;
	}
	
	private void processCollection(Parcel p, double fee) {
		// create new collectedParcel obj, add to collectedParcelList
		// remove p from uncollectedParcelList
		
	}
	
	public void attendToCustomer(ParcelClaim p) {
		Parcel foundParcel;
		//find parcel
		try {
			foundParcel = findParcel(p.getParcelId());
		}
		catch(Exception e) {
			System.out.println("Parcel not found");
			return;
		}
		
		double collectionFee = calculateCollectionFee(foundParcel);
		processCollection(foundParcel, collectionFee);
				
	}

}
