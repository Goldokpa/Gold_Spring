package src;

import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class DepotWorker {
	private List<ParcelClaim> collectionQueue;
	private static ParcelList pList;

	public DepotWorker(ParcelList pList) {
		collectionQueue = new ArrayList<ParcelClaim>();
		
		DepotWorker.pList = pList;
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
		Parcel found = null;
		
		for(Parcel p: pList.getUncollectedParcels()) {
			if(p.getParcelId().equals(parcelId)) {
				found = p;
				break;
			}
		}
		return found;
	}
	
	private double calculateCollectionFee(Parcel p) {
		double fee = 0;
		
		if(p.getNumberOfDaysInDepot() > 7) {
			if(p.getWeight() >= 15) {
				fee = 20;
			}
			else if(p.getWeight() > 5 && p.getWeight() < 15) {
				fee = 15;
			}
			else if(p.getWeight() > 0 && p.getWeight() < 5) {
				fee = 13;
			}
		}
		else {
			if(p.getWeight() >= 15) {
				fee = 15;
			}
			else if(p.getWeight() > 5 && p.getWeight() < 15) {
				fee = 10;
			}
			else if(p.getWeight() > 0 && p.getWeight() < 5) {
				fee = 8;
			}
		}
		
		//for discount
		if(p.getParcelId().startsWith("C")) {
			fee *= 0.9;
		}
			
		return fee;
	}
	
	private void processCollection(Parcel p, double fee) {
		p.setCollectionFee(fee);
		pList.addParcelToCollectedList(p);
		pList.removeParcelFromUnCollectedList(p);
		p.setCollected(true);
	}
	
	public void attendToCustomer(ParcelClaim p) {
		Parcel foundParcel;
		//find each parcel from the claim
		System.out.println("Processing customer " + p.getCustomerName());
		
		for(int i = 0; i < p.getParcelIds().length; i++) {
			try {
				//trim possible spaces in ids in claim array of ids
				foundParcel = findParcel(p.getParcelIds()[i].trim());
				
				double collectionFee = calculateCollectionFee(foundParcel);
				processCollection(foundParcel, collectionFee);
				System.out.println("Parcel Id " + p.getParcelIds()[i] + " claimed!");
			}
			catch(NullPointerException e) {
				System.out.println("Parcel not found");
				return;
			}
		}	
		System.out.println("\nMoving on to next customer...");
	}

}
