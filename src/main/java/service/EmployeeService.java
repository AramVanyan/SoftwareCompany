package service;

import model.Employee;

import java.util.ArrayList;

public class EmployeeService {
    private static ArrayList<Employee> listOfEmployees;
    static {
        listOfEmployees = new ArrayList<>();
    }

    public static void create(Employee employee) {
        listOfEmployees.add(employee);
    }

    public static void update(int id,String employeeName,int departmentId) {
        Employee oldEmployeeState = listOfEmployees.get(id);
        oldEmployeeState.setName(employeeName);
        oldEmployeeState.setDepartmentId(departmentId);
    }

    public static Employee getEmployeeById(int id) {
        return listOfEmployees.get(id);
    }

}
