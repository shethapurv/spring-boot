package com.shethap.tech.rediscounterservice;

import com.shethap.tech.rediscounterservice.entity.Counter;
import com.shethap.tech.rediscounterservice.service.CounterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
@Slf4j
public class CounterApi {

    private CounterService counterService;

    public CounterApi(CounterService counterService) {
        this.counterService = counterService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/increment")
    public Counter incrementCount() {
        Counter counter = counterService.increment();
        log.info("counter is -> " + counter.getCount());
        return counter;

    }

    @RequestMapping(method = RequestMethod.GET, path = "/decrement")
    public Counter decrement() {
        Counter counter = counterService.decrement();
        log.info("counter is -> " + counter.getCount());
        return counter;

    }

    @RequestMapping(method = RequestMethod.GET, path = "/reset")
    public Counter reset() {
        Counter counter = counterService.reset();
        log.info("counter is -> " + counter.getCount());
        return counter;
    }
}
