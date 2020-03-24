package test.service;

import model.Department;
import model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import service.DepartmentService;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DepartmentServiceTest {


    @Parameterized.Parameter(0)
    public int departmentId;
    @Parameterized.Parameter(1)
    public ArrayList<Employee> employees;
    public static String[] namesOfDepartments;

    static {
        namesOfDepartments = new String[]{
          "Math","Programming","Law"
        };
    }


    @Before
    public void initializeDepartments() {
        DepartmentService.create(new Department(1,"Math"));
        DepartmentService.create(new Department(2,"Programming"));
        DepartmentService.create(new Department(3,"Law"));
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {1,new ArrayList<Employee>(){
                    {
                        add(new Employee(1,"Smith",1));
                        add(new Employee(2,"John",1));
                    }
                }},
                {2,new ArrayList<Employee>(){
                    {
                        add(new Employee(4,"Arthur",2));
                        add(new Employee(4,"Andrew",2));
                    }
                }},
                {3,new ArrayList<Employee>(){
                    {
                        add(new Employee(3,"Michael",3));
                    }
                }}

        };

        return Arrays.asList(data);
    }

    @Test
    public void assertCreate() {
        assertTrue(DepartmentService.create(new Department(1,"Math")));
    }

    @Test
    public void assertUpdate() {
        assertEquals(employees, DepartmentService
                .update(departmentId, employees)
                .get(new Department(departmentId, namesOfDepartments[departmentId-1])));
    }

    @Test
    public void assertAssignToDepartment() {
        assertEquals(employees, DepartmentService
                .assignToDepartment(departmentId, employees)
                .get(new Department(departmentId, namesOfDepartments[departmentId-1])));
    }

    @Test
    public void assertGetAllEmployees() {
        DepartmentService.update(departmentId,employees);
        assertEquals(employees,DepartmentService.getAllEmployees());
    }

}
