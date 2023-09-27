package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/switch")
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    EmployeeRepository employeeRepository;

    // Creating Employee and check if user already exists

    @PostMapping("/employee/create")
    public String createNewEmployee(@RequestBody Employee employee){
        if(employeeRepository.findByEmpCode(employee.getEmp_code()) == null) {
            logger.info("Post API was called to create Employee");
            employeeRepository.save(employee);
            logger.info("New Employee Created in DataBase");
            return "New Switch Employee Created in Database";
        } else {
            return "Already Exists!!! Create Employee with Different Employee Code ";
        }
    }

    // Getting data of all the employees from the Database

    @GetMapping("/employee/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        logger.info("GET API was called to see all employees");
        List<Employee> empList = new ArrayList<>();
        empList = employeeRepository.findAll();
        logger.info("All Employees Displayed");
        return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
    }

    // Getting Data of the provided ID only

    @GetMapping("/employee/id/{emp_id}")
    public Optional<Employee> getEmployeeById(@PathVariable(value = "emp_id")int id){
        logger.info("GET API was called to see employee by ID");
        return employeeRepository.findById(id);
    }

    @GetMapping("/employee/name/{emp_name}")
    public Employee getEmployeeByName(@PathVariable(value = "emp_name")String name){
        return employeeRepository.findByEmpName(name);
    }

    // Updating Employee Data

    @PutMapping("/employee/update/{emp_id}")
    public String updateEmployeeById(@PathVariable int emp_id, @RequestBody Employee employee){
    logger.info("PUT API was called to update employee by ID");
    Optional<Employee> emp = employeeRepository.findById(emp_id);
    if(emp.isPresent()){
        Employee existEmp = emp.get();
        existEmp.setEmp_name(employee.getEmp_name());
        existEmp.setEmp_designation(employee.getEmp_designation());
        existEmp.setEmp_salary(employee.getEmp_salary());
        existEmp.setEmp_department(employee.getEmp_department());
        existEmp.setEmp_code(employee.getEmp_code());
        employeeRepository.save(existEmp);
        return "Employee Details against ID " + emp_id + " Updated";
        }else{
            return "Employee Details doesn't exist" + emp_id;
        }
    }

    // Deleting Employee by ID

    @DeleteMapping("/employee/delete/{emp_id}")
    public String deleteEmployeeById(@PathVariable int emp_id){
        logger.info("DELETE API was called to remove employee data from DB by ID");
        employeeRepository.deleteById(emp_id);
        return "Given Employee ID deleted ";
    }

    // Deleting all employees from the Database

    @DeleteMapping("/employee/deleteall")
    public String deleteAllEmployee(){
        logger.info("DELETE API was called to remove employee data from DataBase");
        employeeRepository.deleteAll();
        return "All Employee records deleted";
    }
}
