package com.quantasnet.qtrack.service;

import com.quantasnet.qtrack.domain.db.User;
import com.quantasnet.qtrack.domain.repo.UserRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService
{
    @Resource
    private UserRepo userRepo;

    @Override
    public User findByUsername(String userName)
    {
        return userRepo.findOneByUserName(userName);
    }

    @Override
    public User save(User user)
    {
        return userRepo.saveAndFlush(user);
    }
}