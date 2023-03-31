package src;

import java.util.ArrayList;
import java.util.List;

public class ParcelList {
    List<Parcel> uncollectedParcels; // List of uncollected parcels
    List<Parcel> collectedParcels; // List of collected parcels

    // Constructor to create a new empty list of parcels
    public ParcelList() {
        uncollectedParcels = new ArrayList<Parcel>();
        collectedParcels = new ArrayList<Parcel>();
    }

    // Method to add a new parcel to the list of uncollected parcels
    public void addParcel(Parcel parcel) {
        uncollectedParcels.add(parcel);
    }

    // Method to get the list of uncollected parcels
    public List<Parcel> getUncollectedParcels() {
        return uncollectedParcels;
    }
    
    // Method to get the list of collected parcels
    public List<Parcel> getCollectedParcels() {
        return collectedParcels;
    }
    
    public void addParcelToCollectedList(Parcel parcel) {
        collectedParcels.add(parcel);
    }
    
    public void removeParcelFromUnCollectedList(Parcel parcel) {
        uncollectedParcels.remove(parcel);
    }

}
