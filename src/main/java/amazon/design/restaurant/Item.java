package amazon.design.restaurant;

public class Item {

    Food food;
    boolean isServed;
    int quantity;
    double totalPrice;

    public Item(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isServed() {
        return isServed;
    }

    public void setServed(boolean served) {
        isServed = served;
    }
}
