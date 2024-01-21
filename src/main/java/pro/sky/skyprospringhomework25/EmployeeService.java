package pro.sky.skyprospringhomework25;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringhomework25.exteptions.EmployeeAlreadyAddedException;
import pro.sky.skyprospringhomework25.exteptions.EmployeeNotFoundException;
import pro.sky.skyprospringhomework25.exteptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService {
    private final int MAX_COUNT = 10;
    public Map<String, Employee> employees = new HashMap<>(MAX_COUNT);


    public void addEmployee(String firstName, String lastName) throws EmployeeAlreadyAddedException {
        if (employees.size() >= MAX_COUNT) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName);
        var key = makeKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(key, employee);

    }

    public void removeEmployee(String firstName, String lastName) {
        var key = makeKey(firstName, lastName);
        var removed = employees.remove(key);
        if (removed == null) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(key);
    }

    public Employee findEmployee(String firstName, String lastName) {
        var key = makeKey(firstName, lastName);
        var employee = employees.get(key);
        if (employee != null) {
           return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees.values());

    }

    private static String makeKey(String firstName, String lastName) {
        return (firstName + "_" + lastName).toLowerCase();
    }
}
