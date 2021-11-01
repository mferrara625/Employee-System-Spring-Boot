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
//            if(!employee.getLastName().equals("Employee"))       // removes all instances of "Valued Employee" from employee List
            output += "<br> ID: " + employee.getId() + "  " + employee.getFirstName() + " " + employee.getLastName();
        }
        return "Welcome To Employee System: <br>" + output + "<br> <br> <a href=\"/dummyEmployee\">Dummy Employee</a> <br> <a href=\"/createEmployee\">Create Employee (Request Param)</a> <br> <a href=\"/employeeLastName/\">Employee Last Name (Path Variable)</a> <br> <a href=\"/returnHome/\">A Page That Links Back To This Page</a>";
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

    @GetMapping("/returnHome")
    public String linkHome(){
        return "<a href=\"/\">Homepage</a>";
    }
}
