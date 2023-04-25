package interfaces;

public interface ParcelListSubject {
	public void registerObserver(ParcelListObserver obs);
	
    public void removeObserver(ParcelListObserver obs);
    
    public void notifyObservers();
}
