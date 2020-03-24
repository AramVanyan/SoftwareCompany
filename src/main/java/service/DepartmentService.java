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
    public static boolean create(Department department) {
        departments.put(department,new ArrayList<Employee>());
        return departments.size() > 0;
    }

    public static Map<Department, ArrayList<Employee>> update(int departmentId,ArrayList<Employee> employees) {
        departments.entrySet().stream()
                .filter(e -> e.getKey().getId() == departmentId)
                .forEach(e -> {
                    e.getValue().clear();
                    e.getValue().addAll(employees);
                });
        return departments;
    }

    public static Map<Department, ArrayList<Employee>> assignToDepartment(int departmentId,ArrayList<Employee> employees) {
        departments.entrySet().stream()
                .filter(e -> e.getKey().getId() == departmentId)
                .forEach(e -> e.getValue().addAll(employees));
        return departments;
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> listOfEmployees = new ArrayList<>();
        departments.forEach((key, value) -> listOfEmployees.addAll(value));
        return listOfEmployees;
    }

}
