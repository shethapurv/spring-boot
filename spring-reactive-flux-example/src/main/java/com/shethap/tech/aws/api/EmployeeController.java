package com.shethap.tech.aws.api;


import com.shethap.tech.aws.entity.Employee;
import com.shethap.tech.aws.service.EmployeeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/{lastName}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Employee> getEmployee(@PathVariable String lastName) {
        return employeeService.findByLastName(lastName);
    }

    @PostMapping(value = "/save", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Employee> save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Employee> getEmployees() {
        return employeeService.findAll();
    }
}
