package grp.work;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * this method goes through the uncollected parcels list to confirm the parcel exists
     * @param parcelId
     * @return parcel matching the provided parcelId
     */
    public Parcel findParcel(String parcelId) {
        Parcel found = null;

        for (Parcel p : pList.getUncollectedParcels()) {
            if (p.getParcelId().equals(parcelId)) {
                found = p;
                break;
            }
        }
        return found;
    }

    /**
     * This method showcases how to calculate collection fee per parcel. Rules given
     * are:
     *  - all parcels that have been in the depot for more than 7 days have a higher base fee (£20 vs. £15 for less than 7 days),
     *  - the fee is further calculated based on weight range e.g. parcels weighing less than 5kg have a
     * base fee of £13 while parcels greater than 15kg is still £20,
     * - finally, parcels with ID starting with "X" are labeled as untracked parcels, hence have a 10% discount on collection fee
     * wile parcels with "C" are tracked
     *
     * @param p parcel object
     * @return collection fee for the parcel
     */

    public double calculateFee(Parcel p) {
        double fee = 0;

        if (p.getDaysInDepot() >= 7) {
            if (p.getWeight() > 15) {
                fee = 20;
            } else if (p.getWeight() > 5 && p.getWeight() <= 15) {
                fee = 15;
            } else if (p.getWeight() > 0 && p.getWeight() <= 5) {
                fee = 13;
            }
        } else {
            if (p.getWeight() > 15) {
                fee = 15;
            } else if (p.getWeight() > 5 && p.getWeight() <= 15) {
                fee = 10;
            } else if (p.getWeight() > 0 && p.getWeight() <= 5) {
                fee = 8;
            }
        }

        // for 10% discount
        if (p.getParcelId().startsWith("X")) {
            fee *= 0.9;
        }

        return fee;
    }

    /**
     * This method processes parcel collection by setting its collection fee, adding
     * it to the list of collected parcels and removing from uncollected list
     *
     * @param p   parcel
     * @param fee collection fee
     */
    public void processCollection(Parcel p, double fee) {
        p.setCollectionFee(fee);
        pList.addParcelToCollectedList(p);
        pList.removeParcelFromUnCollectedList(p);
        p.setCollected(true);
    }

    /**
     * This method processes each parcel claim by: searching for the parcels, if
     * found, calculating the collection fee, marking as collected. Claims do not
     * need to be customer-validated as customers were created using the claims
     * file, hence all the customers for claims will exist
     *
     * @param p parcelClaim object
     */
    public void attendToCustomer(ParcelClaim p) {
        Parcel foundParcel;

        System.out.println("Processing customer " + p.getCustomerName());

        // find each parcel from the claim
        for (int i = 0; i < p.getParcelIds().length; i++) {
            try {
                // trim possible spaces in ids in claim array of ids
                foundParcel = findParcel(p.getParcelIds()[i].trim());

                // if parcel found, calculate collection fee
                double collectionFee = calculateFee(foundParcel);

                // process the collection
                processCollection(foundParcel, collectionFee);

                System.out.println("Parcel Id " + p.getParcelIds()[i] + " claimed!");
            } catch (NullPointerException e) {
                System.out.println("Parcel " + p.getParcelIds()[i] + " not found");
            }
        }
        System.out.println("\nMoving on to next customer...");
    }

}
