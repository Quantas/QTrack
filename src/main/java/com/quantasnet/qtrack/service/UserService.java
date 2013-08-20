package com.quantasnet.qtrack.service;

import com.quantasnet.qtrack.domain.db.User;

public interface UserService
{
    User findByUsername(String userName);

    User getCurrentUser();

    User save(User user);

    String generateGravatarHash(String email);
}