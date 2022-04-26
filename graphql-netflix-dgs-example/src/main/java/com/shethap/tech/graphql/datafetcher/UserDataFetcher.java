package com.shethap.tech.graphql.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.shethap.tech.graphql.model.User;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class UserDataFetcher {

    private final List<User> users = List.of(
            User.builder().id(1).name("Alex").build(),
            User.builder().id(2).name("Paras").build(),
            User.builder().id(3).name("Apurv").build(),
            User.builder().id(4).name("Brad").build(),
            User.builder().id(5).name("Ivo").build(),
            User.builder().id(6).name("Bharat").build()
    );

    @DgsQuery
    public List<User> users(@InputArgument String nameFilter) {
        if (nameFilter == null) {
            return users;
        }
        return users.stream().filter(s -> s.getName().contains(nameFilter)).collect(Collectors.toList());
    }

    @DgsMutation
    public boolean deleteUser(@InputArgument Integer id) {
        boolean isUserRemoved = Boolean.FALSE;
        if(users.stream().filter(s -> s.getId() == id ).count() == 0)
            return isUserRemoved;
        isUserRemoved = users.remove(id);
        return isUserRemoved;
    }
}
