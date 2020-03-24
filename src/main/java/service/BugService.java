package service;

import model.Bug;
import model.Employee;

import java.util.HashMap;
import java.util.Map;

public class BugService {
    private static Map<Bug, Employee> bugs;
    static {
        bugs = new HashMap<>();
    }

    public static void create(Bug bug) {
        bugs.put(bug,null);
    }

    public static void update(int bugId,Employee employee) {
        bugs.entrySet().stream()
                .filter(e -> e.getKey().getId() == bugId)
                .forEach(e -> {
                    Employee oldEmployee = e.getValue();
                    oldEmployee = employee;
                });
    }

    public static void assignToUser(int bugId,Employee employee) {
        bugs.entrySet().stream()
                .filter(e -> e.getKey().getId() == bugId)
                .forEach(e -> {
                    Employee oldEmployee = e.getValue();
                    oldEmployee = employee;
                });
    }
}
