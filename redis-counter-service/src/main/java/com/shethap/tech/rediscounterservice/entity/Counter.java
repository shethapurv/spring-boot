package com.shethap.tech.rediscounterservice.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;

@RedisHash("Counter")
@Builder
@Data
public class Counter {

    private String id;
    private BigDecimal count;
}
