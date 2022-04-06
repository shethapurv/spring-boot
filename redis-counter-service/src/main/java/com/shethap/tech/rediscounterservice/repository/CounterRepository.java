package com.shethap.tech.rediscounterservice.repository;

import com.shethap.tech.rediscounterservice.entity.Counter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends CrudRepository<Counter, String> {

}