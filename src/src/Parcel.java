package src;

public class Parcel {
    public String parcelId;

    private double weight;
    private double length;
    private double width;
    private double height;
    private int daysInDepot;
    private boolean collected;

    public Parcel(String parcelId, double weight, double length, double width, double height, int daysInDepot) {
        this.parcelId = parcelId;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.daysInDepot = daysInDepot;
        this.collected = false;
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

    public void markAsCollected() {
    }
}

