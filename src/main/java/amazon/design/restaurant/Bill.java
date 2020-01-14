package amazon.design.restaurant;


public class Bill {

    Order order;

    public void generateBill() {
        System.out.println("Bill : ");
        System.out.println(order.time);
        for (Item item : order.items) {
            System.out.println(item.food.name + " : " + item.totalPrice);
        }
    }

    public void generateSplitBill() {

    }

}
