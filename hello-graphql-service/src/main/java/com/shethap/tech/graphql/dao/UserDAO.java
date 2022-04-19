package com.shethap.tech.graphql.dao;

import com.shethap.tech.graphql.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    private List<User> userList;

    public UserDAO() {
        User user = User.builder().name("Apurv").id(1).build();
        if(!CollectionUtils.isEmpty(userList)) {
            userList.add(user);
        } else {
            userList = new ArrayList<>();
            userList.add(user);
        }
    }

    public List<User> getUsers() {
        return this.userList;
    }

    public User saveUsers(User user) {
        userList.add(user);
        return user;
    }
}
