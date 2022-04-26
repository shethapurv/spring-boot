package com.shethap.tech.graphql.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class User {

    private String name;
    private Integer id;
}