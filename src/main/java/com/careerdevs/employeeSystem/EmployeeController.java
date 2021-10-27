package com.careerdevs.employeeSystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class EmployeeController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public String rootRoute(){
        return "Welcome To Employee System";
    }

    @GetMapping("/dummyEmployee")
    public Employee dummyEmployee(){
        return new Employee(8, "Bob", "Ross");
    }

    @GetMapping("/createEmployee")
    public Employee createEmployee(@RequestParam(value = "firstName", defaultValue = "Valued") String firstName, @RequestParam(value = "lastName", defaultValue = "Employee") String lastName){
        return new Employee(counter.incrementAndGet(), firstName, lastName);
    }

    @GetMapping("/employeeLastName/{lastName}")
    public Employee employeeLastName(@PathVariable String lastName){
        return new Employee(counter.incrementAndGet(), "Employee", lastName);
    }
}
