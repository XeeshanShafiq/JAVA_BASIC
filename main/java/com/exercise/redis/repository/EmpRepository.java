package com.exercise.redis.repository;

import com.exercise.redis.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmpRepository extends CrudRepository<Employee, Integer> {

}
