//package com.exercise.redis.repository;
//
//import com.exercise.redis.model.Employee;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.Map;
//
//@Repository
//public class EmployeeRepository {
//
//    final Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);
//    private HashOperations hashOperations;
//
//    @Autowired
//    public EmployeeRepository(RedisTemplate redisTemplate) {
//        this.hashOperations = redisTemplate.opsForHash();
//    }
//
//    public Employee create(Employee employee) {
//        hashOperations.put("EMPLOYEE", employee.getId(), employee);
//        return employee;
//    }
//
//    public Employee get(int id) {
//        return (Employee) hashOperations.get("EMPLOYEE", id);
//    }
//
//    public Map<String, Employee> getAll(){
//        return hashOperations.entries("EMPLOYEE");
//    }
//
//    public Employee update(int id, Employee employee) {
//        hashOperations.put("EMPLOYEE", id, employee);
//        return (Employee) hashOperations.get("EMPLOYEE", id);
//    }
//
//    public String delete(int id) {
//        hashOperations.delete("EMPLOYEE", id);
//        return "Deleted";
//    }
//}