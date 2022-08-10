package com.shethap.tech.scope.api;

import com.shethap.tech.scope.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/beanScope", method = RequestMethod.GET)
public class BeanScopeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(path = "/prototypeTreatedAsSingleton", method = RequestMethod.GET)
    public List<Integer> getDepartmentIdWithDeptTreatedAsSingleton() throws InterruptedException {
        return employeeService.getDepartmentIdWithDeptTreatedAsSingleton();
    }

    @RequestMapping(path = "/withApplicationContext", method = RequestMethod.GET)
    public List<Integer> getDepartmentIdWithApplicationContext() throws InterruptedException {
        return employeeService.getDepartmentIdWithApplicationContext();
    }

    @RequestMapping(path = "/withObjectFactory", method = RequestMethod.GET)
    public List<Integer> getDepartmentIdWithObjectFactory() throws InterruptedException {
        return employeeService.getDepartmentIdWithObjectFactory();
    }

    @RequestMapping(path = "/withLookUp", method = RequestMethod.GET)
    public List<Integer> getDepartmentIdWithLookUp() throws InterruptedException {
        return employeeService.getDepartmentIdWithLookUp();
    }


}
