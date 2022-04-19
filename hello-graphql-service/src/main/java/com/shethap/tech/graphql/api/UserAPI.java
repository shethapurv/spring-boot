package com.shethap.tech.graphql.api;

import com.shethap.tech.graphql.model.User;
import com.shethap.tech.graphql.service.UserService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Component;

import java.util.List;


@GraphQLApi
@Component
public class UserAPI {

    UserService userService;

    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @GraphQLQuery(name = "getUsers", description = "to get all the users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GraphQLMutation(name = "saveUser", description = "to save user")
    public User saveUsers(@GraphQLArgument(name = "user") User user) {
        return userService.saveUser(user);
    }
}
