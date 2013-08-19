package com.quantasnet.qtrack.service;

import com.quantasnet.qtrack.domain.db.User;
import com.quantasnet.qtrack.domain.repo.UserRepo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
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

    @Override
    public String generateGravatarHash(String email)
    {
        return DigestUtils.md5Hex(email.trim().toLowerCase());
    }
}