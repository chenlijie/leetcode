package ebay.design.parkinglot;

public enum VehicleSize {

    SMALL(1), MEDIUM(2), LARGE(3), XLARGE(4);

    private int label;

    VehicleSize(int label) {
        this.label = label;
    }

    public int getLabel() {
        return label;
    }
}
