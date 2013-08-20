package com.quantasnet.qtrack.service;

import com.quantasnet.qtrack.domain.db.Role;
import com.quantasnet.qtrack.domain.db.User;

import java.util.List;

public interface UserService
{
    User findByUsername(String userName);

    User getCurrentUser();

    User save(User user);
    User save(String userName, String firstName, String lastName, String email, String password, List<Role> roles);
}