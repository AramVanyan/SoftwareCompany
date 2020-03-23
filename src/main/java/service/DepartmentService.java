package service;

import model.Department;
import model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentService {
    private static Map<Department, ArrayList<Employee>> departments;

    static {
        departments = new HashMap<>();
    }
    public static void create(Department department) {
        departments.put(department,new ArrayList<Employee>());
    }

    public static void update(Department department,ArrayList<Employee> employees) {
        ArrayList<Employee> oldEmployeesList = departments.get(department);
        oldEmployeesList = employees;
    }

    public static void assignToDepartment(Department department,ArrayList<Employee> employees) {
        ArrayList<Employee> oldEmployeesList = departments.get(department);
        oldEmployeesList.addAll(employees);
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> listOfEmployees = new ArrayList<>();
        departments.forEach((key, value) -> listOfEmployees.addAll(value));
        return listOfEmployees;
    }

}
