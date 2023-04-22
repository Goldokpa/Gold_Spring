package grp.work;

public interface ParcelListSubject {
    void registerObserver(ParcelListObserver var1);

    void removeObserver(ParcelListObserver var1);

    void notifyObservers();
}
