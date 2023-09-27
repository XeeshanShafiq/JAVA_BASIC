package com.exercise.redis.controller;

import com.exercise.redis.model.Employee;
import com.exercise.redis.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmpRepository empRepository;

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = empRepository.save(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateStudent(@PathVariable(name = "id") int id, @RequestBody Employee employee) {
        Optional<Employee> emp = empRepository.findById(id);
        if (emp.isPresent()) {
            Employee employeeDB = emp.get();
            employeeDB.setDesignation(employee.getDesignation());
            employeeDB.setName(employee.getName());
            Employee updatedEmployee = empRepository.save(employeeDB);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.CREATED);
        }
        return null;
    }

    @GetMapping("/allEmployee")
    public ResponseEntity<List<Employee>> getEmployee() {
        List<Employee> employee = new ArrayList<>();
        empRepository.findAll().forEach(employee::add);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


}