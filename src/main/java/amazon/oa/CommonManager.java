package amazon.oa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommonManager {

    static class Employee {
        int id;
        List<Employee> employees;

        public Employee(int id) {
            this.id = id;
            employees = new ArrayList<>();
        }
    }

    static Employee getCommonManager_2(Employee manager, Employee e1, Employee e2) {
        Stack<Employee> m1 = new Stack<>();
        find(manager, e1, m1);
        if (m1.size() == 0)
            return null;

        Stack<Employee> m2 = new Stack<>();
        find(manager, e2, m2);
        if (m2.size() == 0)
            return null;

        Employee pre = null;
        while (m1.peek() == m2.peek()) {
            pre = m1.pop();
            m2.pop();
        }

        return pre == manager ? null : pre;
    }

    private static boolean find(Employee manager, Employee e1, Stack<Employee> m1) {
        if (manager == e1)
            return true;

        if (manager.employees != null) {
            for (Employee e : manager.employees) {
                if (find(e, e1, m1)) {
                    m1.push(e);
                    return true;
                }
            }
        }

        return false;
    }

    static Employee getCommonManager(Employee manager, Employee e1, Employee e2) {
        if (manager == null || e1 == manager || e2 == manager)
            return manager;

        Employee m1 = null;
        Employee m2 = null;

        for (Employee e : manager.employees) {
            Employee t = getCommonManager(e, e1, e2);
            if (t != null) {
                if (m1 == null)
                    m1 = t;
                else
                    m2 = t;
            }
        }

        return m2 != null ? manager : m1;
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[20];

        for (int i = 1; i < employees.length; i++) {
            employees[i] = new Employee(i);
        }

        employees[1].employees.add(employees[2]);
        employees[1].employees.add(employees[3]);
        employees[1].employees.add(employees[4]);

        employees[2].employees.add(employees[5]);
        employees[2].employees.add(employees[6]);

        employees[3].employees.add(employees[7]);

        employees[4].employees.add(employees[8]);
        employees[4].employees.add(employees[9]);
        employees[4].employees.add(employees[10]);

        employees[8].employees.add(employees[11]);

        employees[11].employees.add(employees[12]);
        employees[11].employees.add(employees[13]);
        employees[11].employees.add(employees[14]);


        System.out.println(getCommonManager_2(employees[1], employees[5], employees[10]));
        System.out.println(getCommonManager_2(employees[1], employees[12], employees[18]));
        System.out.println(getCommonManager_2(employees[1], employees[13], employees[9]).id);
        System.out.println(getCommonManager_2(employees[1], employees[13], employees[12]).id);

//        System.out.println(getCommonManager(employees[1], employees[5], employees[18]).id);
//        System.out.println(getCommonManager(employees[1], employees[5], employees[10]).id);
//        System.out.println(getCommonManager(employees[1], employees[5], employees[7]).id);
//        System.out.println(getCommonManager(employees[1], employees[6], employees[5]).id);
//        System.out.println(getCommonManager(employees[1], employees[8], employees[2]).id);
//        System.out.println(getCommonManager(employees[1], employees[13], employees[9]).id);
//        System.out.println(getCommonManager(employees[1], employees[14], employees[6]).id);
    }
}
