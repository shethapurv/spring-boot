package com.shethap.tech.aws.service;

import com.shethap.tech.aws.dao.EmployeeRepository;
import com.shethap.tech.aws.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@Slf4j
public class EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Flux<Employee> findByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    public Mono<Employee> save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Flux<Employee> findAll() {
        return employeeRepository.findAll().doOnNext(employee -> {
            log.info("Employee found with findAll():");
            log.info("--------------------------------");
            log.info(employee.toString());
            log.info("");
        }).delayElements(Duration.ofSeconds(5));
    }
}
