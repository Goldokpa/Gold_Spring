package src;

import java.util.ArrayList;
import java.util.List;

//Singleton class? - Only need one instance since all workers will be working with the same parcel inventory
public class ParcelList {
    private static List<Parcel> uncollectedParcels; // List of uncollected parcels
    private static List<Parcel> collectedParcels; // List of collected parcels

    // Constructor to create a new empty list of parcels
    public ParcelList() {
        uncollectedParcels = new ArrayList<Parcel>();
        collectedParcels = new ArrayList<Parcel>();
    }

    // Method to add a new parcel to the list of uncollected parcels
    public static void addParcel(Parcel parcel) {
        uncollectedParcels.add(parcel);
    }

    // Method to get the list of uncollected parcels
    public static List<Parcel> getUncollectedParcels() {
        return uncollectedParcels;
    }
    
    // Method to get the list of collected parcels
    public static List<Parcel> getCollectedParcels() {
        return collectedParcels;
    }
    
    public static void addParcelToCollectedList(Parcel parcel) {
        collectedParcels.add(parcel);
    }
    
    public static void removeParcelFromUnCollectedList(Parcel parcel) {
        uncollectedParcels.remove(parcel);
    }

}
