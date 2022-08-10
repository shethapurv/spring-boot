package com.shethap.tech.scope.service;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    DepartmentService departmentService;
    public List<Integer> getDepartmentIdWithDeptTreatedAsSingleton() throws InterruptedException {
        int dep1 = departmentService.getDepartmentId();
        Thread.sleep(1000L);
        int dep2 = departmentService.getDepartmentId();
        return List.of(dep1, dep2);
    }

    @Autowired
    ApplicationContext applicationContext;

    public List<Integer> getDepartmentIdWithApplicationContext() throws InterruptedException {
        int dep1 = applicationContext.getBean(DepartmentService.class).getDepartmentId();
        Thread.sleep(1000L);
        int dep2 = applicationContext.getBean(DepartmentService.class).getDepartmentId();
        return List.of(dep1, dep2);
    }

    public List<Integer> getDepartmentIdWithLookUp() throws InterruptedException {
        int dep1 = getDepartmentService().getDepartmentId();
        Thread.sleep(1000L);
        int dep2 = getDepartmentService().getDepartmentId();
        return List.of(dep1, dep2);

    }

    @Lookup
    public DepartmentService getDepartmentService() {
        return null;
    }

    @Autowired
    private ObjectFactory<DepartmentService> departmentServiceObjectFactory;

    public List<Integer> getDepartmentIdWithObjectFactory() throws InterruptedException {
        int dep1 = departmentServiceObjectFactory.getObject().getDepartmentId();
        Thread.sleep(1000L);
        int dep2 = departmentServiceObjectFactory.getObject().getDepartmentId();
        return List.of(dep1, dep2);

    }
}
