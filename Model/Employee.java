package com.example.demo.model;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;
import javax.persistence.*;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emp_id;
    @Column(name = "emp_name")
    private String emp_name;
    @Column(name = "emp_designation")
    private String emp_designation;
    @Column(name = "emp_salary")
    private int emp_salary;
    @Column(name = "emp_department")
    private String emp_department;
    @Column(name = "emp_code", nullable = false)
    private String emp_code;

}
