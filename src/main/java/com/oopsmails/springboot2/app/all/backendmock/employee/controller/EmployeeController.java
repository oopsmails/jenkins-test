package com.oopsmails.springboot2.app.all.backendmock.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oopsmails.springboot2.app.all.backendmock.employee.model.Employee;
import com.oopsmails.springboot2.app.all.backendmock.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee-api")
public class EmployeeController {

    @Autowired
    EmployeeRepository repository;

    @GetMapping("")
//    @PreAuthorize("#oauth2.hasScope('read')")
    public List<Employee> findAll() {
        return repository.findAll();
    }
}
