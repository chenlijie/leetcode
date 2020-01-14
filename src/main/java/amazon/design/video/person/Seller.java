package amazon.design.video.person;

import java.util.ArrayList;
import java.util.List;

public class Seller extends Employee {

    public Seller() {
        type = EmployeeType.Seller;
    }

    @Override
    public List<Employee> getEmployeeInformation() {
        System.out.println("You don't have permission to view other employee's information");
        return new ArrayList<>();
    }

    @Override
    public List<Customer> getAllCustomer() {
        return super.getAllCustomer();
    }

    @Override
    public List<Customer> getCustomer(String firstName, String lastName, String email, String phone) {
        return super.getCustomer(firstName, lastName, email, phone);
    }
}
