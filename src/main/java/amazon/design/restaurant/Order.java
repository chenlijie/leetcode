package amazon.design.restaurant;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    int orderId;

    LocalDateTime time = LocalDateTime.now();

    OrderType orderType;

    OrderStatus orderStatus = OrderStatus.ORDERING;

    List<Item> items = new ArrayList<>();

    Table table;

    String customerName;

    Bill bill;

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public Order(int orderId, OrderType orderType) {
        this.orderId = orderId;
        this.orderType = orderType;
    }

    public Order(int orderId, OrderType orderType, List<Item> items) {
        this.orderId = orderId;
        this.orderType = orderType;
        this.items = items;
    }

    public Order(int orderId, OrderType orderType, String customer, List<Item> items) {
        this.orderId = orderId;
        this.orderType = orderType;
        this.items = items;
        this.customerName = customerName;
    }


    public void addItem(Item item) {
        item.totalPrice = item.quantity * item.food.price;
        items.add(item);
    }

    public void generateBill() {
        System.out.println("Generate bill for order: " + orderId);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
