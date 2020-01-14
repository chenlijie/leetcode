package amazon.design.restaurant.staff;

import amazon.design.restaurant.*;

public class Chef extends Employee {

    EmployeeType type = EmployeeType.CHEF;

    public Chef(int id, String name, Restaurant restaurant) {
        super(id, name);
        this.restaurant = restaurant;
    }

    public void preparingOrder() {
        if (!restaurant.workingOrders.isEmpty()) {
            Order order = restaurant.workingOrders.poll();
            System.out.println("******************************************");
            System.out.println(name + " is working on order: " + order.getOrderId());
            order.setOrderStatus(OrderStatus.PREPARING);

            for (Item item : order.getItems()) {
                System.out.println(item.getFood().getName());
            }
            System.out.println("******************************************");

            order.setOrderStatus(OrderStatus.READY);
            restaurant.notifyWaitress(order);
        } else {
            System.out.println("No order to work");
        }
    }
}
