package amazon.design.restaurant.staff;

import amazon.design.restaurant.Restaurant;

import java.time.LocalDateTime;

public abstract class Employee {

    int id;
    String name;
    EmployeeType employeeType;
    boolean isOnDuty;
    LocalDateTime start;
    LocalDateTime end;
    public Restaurant restaurant;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void login() {
        this.isOnDuty = true;
        start = LocalDateTime.now();
    }

    public void logout() {
        this.isOnDuty = false;
        end = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public boolean isOnDuty() {
        return isOnDuty;
    }

    public void setOnDuty(boolean onDuty) {
        isOnDuty = onDuty;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
