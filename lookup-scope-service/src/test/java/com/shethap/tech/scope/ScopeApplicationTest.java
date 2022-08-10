package com.shethap.tech.scope;

import com.shethap.tech.scope.service.DepartmentService;
import com.shethap.tech.scope.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = {DepartmentService.class, EmployeeService.class})
public class ScopeApplicationTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void singletonTest() {
        EmployeeService employeeService1 = applicationContext.getBean("employeeService", EmployeeService.class);
        EmployeeService employeeService2 = applicationContext.getBean("employeeService", EmployeeService.class);
        Assertions.assertEquals(employeeService1.hashCode(), employeeService2.hashCode());
    }

    @Test
    public void prototypeTest() {
        DepartmentService departmentService1 = applicationContext.getBean("departmentService", DepartmentService.class);
        DepartmentService departmentService2 = applicationContext.getBean("departmentService", DepartmentService.class);
        Assertions.assertNotEquals(departmentService1.hashCode(), departmentService2.hashCode());
    }
}
