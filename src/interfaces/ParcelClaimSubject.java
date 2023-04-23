package interfaces;

public interface ParcelClaimSubject {
	public void registerObserver(ParcelClaimObserver obs);
	
    public void removeObserver(ParcelClaimObserver obs);
    
    public void notifyObservers();
}
