package pro.sky.skyprospringhomework25;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringhomework25.exteptions.EmployeeAlreadyAddedException;
import pro.sky.skyprospringhomework25.exteptions.EmployeeNotFoundException;
import pro.sky.skyprospringhomework25.exteptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private final int MAX_COUNT = 10;
    private final List<Employee> employees = new ArrayList<>(MAX_COUNT);


    public void addEmployee(String lastName, String firstName) {
        if (employees.size() >= MAX_COUNT) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(lastName, firstName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);

    }

    public void removeEmployee(String lastName, String firstName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                employees.remove(employee);
                return;
            }
        }
        throw new EmployeeNotFoundException();

    }

    public Employee findEmployee(String lastName, String firstName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees);

    }
}
