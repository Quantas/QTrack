package com.quantasnet.qtrack.service.factory;

import com.quantasnet.qtrack.domain.db.Role;
import com.quantasnet.qtrack.domain.db.User;
import com.quantasnet.qtrack.service.RoleService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public final class UserFactory
{
    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private RoleService roleService;

    public User make(final String userName, final String firstName, final String lastName, final String email, final String password, final List<Role> roles)
    {
        final User user = new User();
        user.setActive(true);
        user.setRoles(roles);
        user.setEmail(email);
        user.setGravatarHash(generateGravatarHash(email));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName(userName);
        user.setPassword(encodePassword(password));

        return user;
    }

    public User make(final User user)
    {
        user.setPassword(encodePassword(user.getPassword()));

        // Add default Role
        final List<Role> roleList = new ArrayList<Role>();
        final List<Role> dbRoles = roleService.findAll();

        for (final Role role : dbRoles)
        {
            // TODO get default role somewhere else
            if (role.getRoleName().equals("ROLE_USER"))
            {
                roleList.add(role);
                break;
            }
        }

        user.setGravatarHash(generateGravatarHash(user.getEmail()));
        user.setRoles(roleList);
        user.setActive(true);

        return user;
    }

    private String encodePassword(final String password)
    {
        return passwordEncoder.encode(password);
    }

    private String generateGravatarHash(final String email)
    {
        return DigestUtils.md5Hex(email.trim().toLowerCase());
    }
}