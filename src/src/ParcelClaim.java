package src;

public class ParcelClaim {
	private String[] parcelIds;
	private static int sequenceNo = 0;
	private String customerName; //to be changed to Customer object
	
	
	public ParcelClaim(String customerName, String[] parcelIds) {
		this.parcelIds = parcelIds;
		this.customerName = customerName.trim();
		sequenceNo++;
	}

	public String[] getParcelIds() {
		return parcelIds;
	}

	public void setParcelIds(String[] parcelIds) {
		this.parcelIds = parcelIds;
	}

	public static int getSequenceNo() {
		return sequenceNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
}
