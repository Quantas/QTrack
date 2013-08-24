package com.quantasnet.qtrack.service;

import com.quantasnet.qtrack.domain.db.Role;
import com.quantasnet.qtrack.domain.db.User;
import com.quantasnet.qtrack.domain.repo.UserRepo;
import com.quantasnet.qtrack.service.factory.UserFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
    @Resource
    private UserRepo userRepo;

    @Resource
    private UserFactory userFactory;

    @Override
    public User findByUsername(String userName)
    {
        return userRepo.findOneByUserName(userName);
    }

    @Override
    public User getCurrentUser()
    {
        final Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (user instanceof User)
        {
            return (User) user;
        }
        else
        {
            return null;
        }
    }

    @Override
    public User save(User user)
    {
        final User completeUser = userFactory.make(user);

        return userRepo.saveAndFlush(completeUser);
    }

    @Override
    public User save(final String userName, final String firstName, final String lastName, final String email, final String password, final List<Role> roles)
    {
        final User user = userFactory.make(userName, firstName, lastName, email, password, roles);

        return userRepo.saveAndFlush(user);
    }
}