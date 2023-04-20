package src;

public class ParcelClaim {
	private String[] parcelIds;
	private int sequenceNo = 0;
	private String customerName; //not neccessary as a customer object since customers are created from the parcel claims file
	
	private static int lastQueueNumber = 1;
	
	public ParcelClaim(String customerName, String[] parcelIds) {
		this.parcelIds = parcelIds;
		this.customerName = customerName.trim();
		sequenceNo = lastQueueNumber++;
	}

	public String[] getParcelIds() {
		return parcelIds;
	}

	public void setParcelIds(String[] parcelIds) {
		this.parcelIds = parcelIds;
	}

	public int getSequenceNo() {
		return sequenceNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
}
