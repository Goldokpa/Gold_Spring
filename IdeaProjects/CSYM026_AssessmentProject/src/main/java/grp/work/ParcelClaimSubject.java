package grp.work;

public interface ParcelClaimSubject {
    void registerObserver(ParcelClaimObserver var1);

    void removeObserver(ParcelClaimObserver var1);

    void notifyObservers();
}
