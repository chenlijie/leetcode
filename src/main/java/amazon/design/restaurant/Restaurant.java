package amazon.design.restaurant;


import amazon.design.restaurant.staff.*;

import java.util.*;

public class Restaurant {

    int orderId = 1;
    List<Order> allOrders = new ArrayList<>();
    public Queue<Order> workingOrders = new LinkedList<>();
    Map<Integer, Food> allFoods = new HashMap<>();

    Map<Integer, Table> allTables = new HashMap<>();
    List<Table> smallTables = new ArrayList<>();
    List<Table> mediumTables = new ArrayList<>();
    List<Table> largeTables = new ArrayList<>();
    List<Employee> waitresses = new ArrayList<>();
    List<Employee> chefs = new ArrayList<>();
    Employee manager = new Manager(1, "Jimmy");
    Menu menu = new Menu();

    public Restaurant() {

        for (int i = 1; i < 10; i++) {
            Table t = new Table(i, TableSize.SMALL);
            smallTables.add(t);
            allTables.put(i, t);
        }
        for (int i = 10; i < 20; i++) {
            Table t = new Table(i, TableSize.MEDIUM);
            mediumTables.add(t);
            allTables.put(i, t);
        }
        for (int i = 20; i < 30; i++) {
            Table t = new Table(i, TableSize.LARGE);
            largeTables.add(t);
            allTables.put(i, t);
        }

        for (int i = 2; i < 5; i++) {
            addEmployee(i, "waitress " + 1, EmployeeType.WAITRESS);
        }

        for (int i = 6; i < 10; i++) {
            addEmployee(i, "chef " + 1, EmployeeType.CHEF);
        }
        menu.add(new Food(1, "Apple", "", Category.DESSERT, 1.0, true));
        menu.add(new Food(2, "Small cake", "", Category.DESSERT, 1.0, true));
        menu.add(new Food(3, "Banana", "", Category.DESSERT, 1.0, true));

        menu.add(new Food(4, "Beef Burger", "", Category.ENTREE, 1.0, true));
        menu.add(new Food(5, "Chicken Sandwich", "", Category.ENTREE, 1.0, true));
        menu.add(new Food(6, "Italian Noodle", "", Category.ENTREE, 1.0, true));
        menu.add(new Food(7, "Orange Chicken", "", Category.ENTREE, 1.0, true));
        menu.add(new Food(8, "Pork Rib", "", Category.ENTREE, 1.0, true));

        menu.add(new Food(9, "Coke", "", Category.NON_ALCOHOL, 1.0, true));
        menu.add(new Food(10, "Sprint", "", Category.NON_ALCOHOL, 1.0, true));
        menu.add(new Food(11, "Orange Juice", "", Category.NON_ALCOHOL, 1.0, true));

        menu.add(new Food(12, "Wine", "", Category.DESSERT, 1.0, true));
        menu.add(new Food(13, "Beer", "", Category.DESSERT, 1.0, true));


        for (Food food : menu.desserts) {
            allFoods.put(food.foodId, food);
        }
        for (Food food : menu.entrees) {
            allFoods.put(food.foodId, food);
        }
        for (Food food : menu.nonAlcohols) {
            allFoods.put(food.foodId, food);
        }
        for (Food food : menu.alcohols) {
            allFoods.put(food.foodId, food);
        }
    }

    public Table findAvailableTable(TableSize size) {
        switch (size) {
            case SMALL:
                return findTable(smallTables);
            case MEDIUM:
                return findTable(mediumTables);
            case LARGE:
                return findTable(largeTables);
        }
        return null;
    }

    private Table findTable(List<Table> tables) {
        for (Table t : tables) {
            if (t.isAvailable)
                return t;
        }
        System.out.println("No table is available!");
        return null;
    }

    public void releaseTable(int tableId) {
        allTables.get(tableId).reset();
    }

    public void addEmployee(int id, String name, EmployeeType type) {
        if (type == EmployeeType.WAITRESS) {
            waitresses.add(new Waitress(id, name, this));
        } else {
            chefs.add(new Chef(id, name, this));
        }
    }

    public synchronized int generateOrderId() {
        return orderId++;
    }

    public void addWorkingOrder(Order order) {
        workingOrders.offer(order);
    }

    public void notifyWaitress(Order order) {

        if (order.table == null) {
            System.out.println("Notify receptionist that order: " + order.orderId + " is ready.");
        } else {
            System.out.println("Notify " + order.table.getWaitress().getName() + " order: " + order.orderId + " is ready.");
            order.table.waitress.serve(order);
        }
    }

    public Table getTable(int tableId) {
        return allTables.get(tableId);
    }

    public Food getFood(int foodId) {
        return allFoods.get(foodId);
    }
}
