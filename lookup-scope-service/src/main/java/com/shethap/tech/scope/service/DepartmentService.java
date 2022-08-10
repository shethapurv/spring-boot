package com.shethap.tech.scope.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Scope("prototype")
public class DepartmentService {
    private Integer departmentId = new Random().nextInt(1000);

    public int getDepartmentId(){
        return departmentId;
    }
}
