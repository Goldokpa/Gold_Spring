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

	/**
	 * Constructor to validate and handle errors in input before creating an object
	 * 
	 * @param parcelId
	 * @param daysInDepot
	 * @param weight
	 * @param dim         dimensions (length x width x height)
	 * @throws Exception catch any errors
	 */
	public Parcel(String parcelId, int daysInDepot, double weight, String dim) throws Exception {
		try {
			// parcelIds must be at least 4 characters long, start with a C or X and the
			// rest are numbers
			if ((parcelId.trim().toLowerCase().startsWith("c") || parcelId.trim().toLowerCase().startsWith("x"))
					&& parcelId.length() >= 4) {
				this.parcelId = parcelId.trim();
			} else {
				throw new Exception("Invalid ParcelId");
			}

			if (weight < 0) {
				this.weight = 0.1; // always assume 0.1kg for invalid values
			} else {
				this.weight = weight;
			}
			
			String[] dimensions = dim.split("x");

			length = Double.parseDouble(dimensions[0]);
			width = Double.parseDouble(dimensions[1]);
			height = Double.parseDouble(dimensions[2]);

			if (daysInDepot < 0) {
				this.daysInDepot = 0;
			} else {
				this.daysInDepot = daysInDepot;
			}
			
			this.collected = false;
			collectionFee = 0;
		} catch (Exception e) {
			throw new Exception("Parcel not created, invalid params");
		}
	}

	public String getParcelId() {
		return parcelId;
	}

	public void setParcelId(String id) {
		parcelId = id;
	}

	public int getDaysInDepot() {
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
}
