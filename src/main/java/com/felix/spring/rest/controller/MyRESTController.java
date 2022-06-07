package com.felix.spring.rest.controller;

import com.felix.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;
}
