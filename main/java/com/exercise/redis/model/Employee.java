package com.exercise.redis.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Data
@RedisHash(value = "EMPLOYEE")
public class Employee implements Serializable {
    @Id
    @Indexed
    private int id;
    private String name;
    private String designation;
}
