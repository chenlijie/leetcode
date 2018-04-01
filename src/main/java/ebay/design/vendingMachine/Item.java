package ebay.design.vendingMachine;

public class Item {

    String description;
    double price;
    int quantity;

    public Item(String description, double price, int quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public void decreaseQuantity() {
        quantity--;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
