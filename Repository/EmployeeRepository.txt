package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "Select * From employee where emp_code=:code ",nativeQuery = true)
    Employee findByEmpCode(@Param("code") String code);


    @Query (value = "Select * From employee where emp_name=:name",nativeQuery = true)
    Employee findByEmpName(@Param("name") String name);
}
