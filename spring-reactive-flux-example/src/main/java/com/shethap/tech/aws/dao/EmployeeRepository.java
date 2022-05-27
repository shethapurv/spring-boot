package com.shethap.tech.aws.dao;

import com.shethap.tech.aws.entity.Employee;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Integer> {

    @Query("SELECT id, firstName, lastName FROM employee WHERE lastName = :lastname")
    Flux<Employee> findByLastName(String lastName);
}
