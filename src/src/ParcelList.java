package src;

import java.util.ArrayList;
import java.util.List;

//Singleton class - Only need one instance since all workers will be working with the same parcel inventory
public class ParcelList {
    private static List<Parcel> uncollectedParcels; // List of uncollected parcels
    private static List<Parcel> collectedParcels; // List of collected parcels
    
    private static ParcelList instance = null; //the singleton instance for the class

    // Constructor to create a new empty list of parcels, private so it cannot be accessed outside
    private ParcelList() {
        uncollectedParcels = new ArrayList<Parcel>();
        collectedParcels = new ArrayList<Parcel>();
    }
    
    // ensures only one instance of ParcelList gets created throughout the program
    public static ParcelList getInstance() {
       if (instance == null) {
          instance = new ParcelList();
       }
       return instance;
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
