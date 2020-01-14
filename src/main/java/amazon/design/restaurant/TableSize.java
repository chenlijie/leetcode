package amazon.design.restaurant;

public enum TableSize {

    SMALL(2), MEDIUM(4), LARGE(8);

    int size;
    TableSize(int size) {
        this.size = size;
    }
}
