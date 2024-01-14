package pro.sky.skyprospringhomework25;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public void addEmployee(@RequestParam String lastName, @RequestParam String firstName) {

    }

    @GetMapping(path = "/remove")
    public void findEmployee(@RequestParam String lastName, @RequestParam String firstName) {
        employeeService.removeEmployee(lastName, firstName);
    }

    @GetMapping(path = "/find")
    public Employee removeEmployee(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.findEmployee(lastName, firstName);
    }

    @GetMapping(path = "/all")
    public Collection<Employee> getAll() {
        return employeeService.getAll();
    }

}
