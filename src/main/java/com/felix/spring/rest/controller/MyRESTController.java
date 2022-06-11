package com.felix.spring.rest.controller;

import com.felix.spring.rest.entity.Employee;
import com.felix.spring.rest.exception_handling.EmployeeIncorrectData;
import com.felix.spring.rest.exception_handling.NoSuchEmployeeException;
import com.felix.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){

        Employee employee = employeeService.getEmployee(id);
        if(employee == null){
            throw new NoSuchEmployeeException(String.format("There is no employee with employee " +
                    "with ID - %d in Database", id));
        }
        return employee;
    }


}
