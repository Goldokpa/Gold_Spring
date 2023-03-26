package src;

public class ParcelCollection {
    private double collectionFee;
    private Parcel parcel;

    // Constructor to create a new collected parcel
    public ParcelCollection(Parcel parcel, double fee) {
        this.parcel = parcel;
        this.collectionFee = fee;
    }

    // Method to get the collection fee for the parcel
    public double getCollectionFee() {
        return this.collectionFee;
    }

    // Method to get the parcel object associated with this collected parcel
    public Parcel getParcel() {
        return this.parcel;
    }

    // Method to set the collection fee for the parcel
    public void setCollectionFee(double fee) {
        this.collectionFee = fee;
    }

    // Method to set the parcel object associated with this collected parcel
    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }
}
