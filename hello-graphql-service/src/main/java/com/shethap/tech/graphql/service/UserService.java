package com.shethap.tech.graphql.service;

import com.shethap.tech.graphql.dao.UserDAO;
import com.shethap.tech.graphql.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    public User saveUser(User user) {
        return userDAO.saveUsers(user);
    }
}
