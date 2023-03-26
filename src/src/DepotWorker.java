package src;

import java.util.List;
import java.util.ArrayList;

public class DepotWorker {
	private List<ParcelClaim> collectionQueue;
	
	public DepotWorker() {
		collectionQueue = new ArrayList<ParcelClaim>();
		
		//create queue
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
