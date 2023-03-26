package src;

public class Parcel {
	private String parcelId;
	private double weight;
	private double length;
	private double width;
	private double height;
	private int daysInDepot;
	private boolean collected;
	private double collectionFee;

	public Parcel(String parcelId, int daysInDepot, double weight, String dim) throws Exception {
		try {
			this.parcelId = parcelId.trim();
			if (weight < 0) {
				this.weight = 0;
			} else
				this.weight = weight;

			String[] dimensions = dim.split("x");

			length = Double.parseDouble(dimensions[0]);
			width = Double.parseDouble(dimensions[1]);
			height = Double.parseDouble(dimensions[2]);

			this.daysInDepot = daysInDepot;
			this.collected = false;
			collectionFee = 0;
		} 
		catch (Exception e) {
			throw new Exception("Parcel not created, invalid params");
		}
	}

	public String getParcelId() {
		return parcelId;
	}

	public int getNumberOfDaysInDepot() {
		return daysInDepot;
	}

	// getters and setters for other attributes
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public boolean isCollected() {
		return collected;
	}

	public void setCollected(boolean collected) {
		this.collected = collected;
	}

	public double getCollectionFee() {
		return collectionFee;
	}

	public void setCollectionFee(double fee) {
		collectionFee = fee;
	}

	public void markAsCollected() {
	}
}
