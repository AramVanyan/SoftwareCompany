import model.Department;
import model.Employee;
import service.DepartmentService;
import service.EmployeeService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> listOfEmployees = new ArrayList<Employee>(){
            {
              add(new Employee(1,"Smith",1));
              add(new Employee(2,"John",1));
              add(new Employee(3,"Michael",3));
              add(new Employee(4,"Arthur",2));
              add(new Employee(4,"Andrew",2));
            }
        };
        EmployeeService.create(listOfEmployees.get(0));
        System.out.println(EmployeeService.getEmployeeById(0));
        EmployeeService.update(0,"Zara",2);
        System.out.println(EmployeeService.getEmployeeById(0));
        DepartmentService.create(new Department(1,"Math"));
        DepartmentService.create(new Department(2,"Programming"));
        DepartmentService.create(new Department(3,"Law"));
        System.out.println(DepartmentService.getAllEmployees());
        DepartmentService.assignToDepartment(1,new ArrayList<Employee>(){
            {
                add(new Employee(1,"Smith",1));
                add(new Employee(2,"John",1));
            }
        });
        System.out.println(DepartmentService.getAllEmployees());
        DepartmentService.update(1,listOfEmployees);
        System.out.println(DepartmentService.getAllEmployees());

    }
}
