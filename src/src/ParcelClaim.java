package src;

public class ParcelClaim {
	private String parcelId;
	private static int sequenceNo = 0;
	private String customerName; //to be changed to Customer object
	
	
	public ParcelClaim(String parcelId, String customerName) {
		this.parcelId = parcelId;
		this.customerName = customerName;
		sequenceNo++;
	}

	public String getParcelId() {
		return parcelId;
	}

	public void setParcelId(String parcelId) {
		this.parcelId = parcelId;
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
