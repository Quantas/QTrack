package com.quantasnet.qtrack.service;

import com.quantasnet.qtrack.domain.db.Role;
import com.quantasnet.qtrack.domain.db.User;
import com.quantasnet.qtrack.domain.web.SignupUser;

import java.util.List;

public interface UserService
{
    List<User> findAll();

    User findByUsername(String userName);

    User findByEmail(String email);

    User getCurrentUser();

    User save(User user);

    User save(SignupUser signupUser);

    User save(String userName, String firstName, String lastName, String email, String password, List<Role> roles);
}