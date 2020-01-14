package amazon.design.video.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Manager extends Employee {

    public Manager() {
        type = EmployeeType.Manager;
    }

    @Override
    public List<Employee> getEmployeeInformation() {
        System.out.println("Store has below employees: ");
        for (Map.Entry<Integer, Employee> e : store.getEmployees().entrySet()) {
            System.out.println(e.getValue().getFirstName() + " " + e.getValue().getLastName());
        }
        return new ArrayList<>(store.getEmployees().values());
    }

    @Override
    public Employee getEmployeeInformation(String employeeId) {
        return super.getEmployeeInformation(employeeId);
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
