package com.careerdevs.employeeSystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class EmployeeController {

    private final AtomicLong counter = new AtomicLong();
    private final List<Employee> employeeList = new ArrayList<>();

    @GetMapping("/")
    public String rootRoute(){
        String output = "";
        for(Employee employee : employeeList){
            output += "<br>" + employee.getFirstName() + " " + employee.getLastName();
        }
        return "Welcome To Employee System:" + output;
    }

    @GetMapping("/dummyEmployee")
    public Employee dummyEmployee(){
        return new Employee(8, "Bob", "Ross");
    }

    @GetMapping("/createEmployee")
    public Employee createEmployee(@RequestParam(value = "firstName", defaultValue = "Valued") String firstName, @RequestParam(value = "lastName", defaultValue = "Employee") String lastName){
        Employee employee = new Employee(counter.incrementAndGet(), firstName, lastName);
        employeeList.add(employee);
        return employee;
    }

    @GetMapping("/employeeLastName/{lastName}")
    public Employee employeeLastName(@PathVariable String lastName){
        return new Employee(counter.incrementAndGet(), "Employee", lastName);
    }
}
