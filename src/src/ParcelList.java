package src;

import java.util.ArrayList;
import java.util.List;

public class ParcelList {
    List<Parcel> uncollectedParcelList; // List of uncollected parcels
    List<Parcel> collectedParcelList; // List of collected parcels

    // Constructor to create a new empty list of parcels
    public ParcelList() {
        uncollectedParcelList = new ArrayList<>();
        collectedParcelList = new ArrayList<>();
    }

    // Method to add a new parcel to the list of uncollected parcels
    public void addParcel(Parcel parcel) {
        uncollectedParcelList.add(parcel);
    }

    // Method to get the list of uncollected parcels
    public List<Parcel> getUncollectedParcelList() {
        return uncollectedParcelList;
    }

    // Method to get the list of collected parcels
    public List<Parcel> getCollectedParcelList() {
        return collectedParcelList;
    }

    // Method to collect a parcel with the given parcel ID
    public void collectParcel(String parcelId) {
        for (Parcel parcel : uncollectedParcelList) {
            if (parcel.parcelId.equals(parcelId)) { // Check if the parcel ID matches
                parcel.markAsCollected(); // Mark the parcel as collected
                collectedParcelList.add(parcel); // Add the parcel to the list of collected parcels
                uncollectedParcelList.remove(parcel); // Remove the parcel from the list of uncollected parcels
                break; // Exit the loop since we have found the parcel
            }
        }
    }
}
