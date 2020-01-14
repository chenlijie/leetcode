package amazon.design.restaurant.staff;

import amazon.design.restaurant.*;

import java.util.*;

public class Waitress extends Employee {

    EmployeeType type = EmployeeType.WAITRESS;
    LinkedList<Table> tables = new LinkedList<>();

    public Waitress(int id, String name, Restaurant restaurant) {
        super(id, name);
        this.restaurant = restaurant;
    }

    public Table findTable(TableSize size) {
        Table table = restaurant.findAvailableTable(size);

        if (table != null) {
            System.out.println(name + " finds an available table " + table.getTableId());
        } else {
            System.out.println("No table available now");
        }

        return table;
    }

    public void checkIn(int tableId) {
        System.out.println(name + " checkin customer to table: " + tableId);
        Table table = restaurant.getTable(tableId);
        table.setAvailable(false);
    }

    public void placeOrder(int tableId, List<Integer> foodIds) {
        int orderId = restaurant.generateOrderId();
        Order order = null;

        if (tableId == -1) {
            order = new Order(orderId, OrderType.TOGO);
        } else {
            order = new Order(orderId, OrderType.DINING);
            Table table = restaurant.getTable(tableId);
            table.addOrder(order);
        }

        System.out.println("***********************************");
        System.out.println(name + " is placing order for table: " + tableId);
        for (int id : foodIds) {
            order.addItem(new Item(restaurant.getFood(id), 1));
        }
        for (Item item : order.getItems()) {
            System.out.println(item.getFood().getName() + ": " + item.getQuantity());
        }
        order.setOrderStatus(OrderStatus.ORDERED);
        restaurant.addWorkingOrder(order);
        System.out.println("***********************************");
    }

    public void serve(Order order) {
        System.out.println(name + " is delivering order: " + order.getOrderId() + " to customer");
    }


    public void checkOut(int tableId) {
        Table table = restaurant.getTable(tableId);
        table.getOrder().generateBill();
        restaurant.releaseTable(tableId);
    }
}
