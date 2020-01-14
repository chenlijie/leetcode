package amazon.design.restaurant;

import amazon.design.restaurant.staff.Waitress;

public class Table {

    int tableId;
    TableSize size;
    boolean isAvailable;
    Order order;
    Waitress waitress;

    public Table(int id, TableSize size) {
        this.tableId = id;
        this.size = size;
        isAvailable = true;
    }

    public void assignWaitress(Waitress waitress) {
        this.isAvailable = false;
        this.waitress = waitress;
    }

    public void addOrder(Order order) {
        this.order = order;
        order.table = this;
    }

    public void reset() {
        this.isAvailable = true;
        this.waitress = null;
        order = null;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public TableSize getSize() {
        return size;
    }

    public void setSize(TableSize size) {
        this.size = size;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Waitress getWaitress() {
        return waitress;
    }

    public void setWaitress(Waitress waitress) {
        this.waitress = waitress;
    }
}
