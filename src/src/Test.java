package src;

public class Test {

	public static void main(String[] args) {
		
		//step 0: create one depot worker
		
//		Step 1: read both csv files
		
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

}
