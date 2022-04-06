package com.shethap.tech.rediscounterservice.service;

import com.shethap.tech.rediscounterservice.entity.Counter;
import com.shethap.tech.rediscounterservice.repository.CounterRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CounterService {

    private CounterRepository counterRepository;

    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    public Counter increment() {

        Counter currentCount = counterRepository.findById("visitCounter").orElse(Counter.builder().id("visitCounter").count(BigDecimal.ONE).build());
        Counter counter = counterRepository.save(Counter.builder().id("visitCounter").count(currentCount.getCount().add(BigDecimal.ONE)).build());
        return counter;
    }
    public Counter reset() {
        Counter counter = counterRepository.save(Counter.builder().id("visitCounter").count(BigDecimal.ONE).build());
        return counter;
    }
    public Counter decrement() {

        Counter currentCount = counterRepository.findById("visitCounter").orElse(Counter.builder().id("visitCounter").count(BigDecimal.ONE).build());
        Counter counter = counterRepository.save(Counter.builder().id("visitCounter").count(currentCount.getCount().subtract(BigDecimal.ONE)).build());
        return counter;
    }
}
