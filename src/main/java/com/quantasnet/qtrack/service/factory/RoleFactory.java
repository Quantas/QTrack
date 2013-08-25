package com.quantasnet.qtrack.service.factory;

import com.quantasnet.qtrack.domain.db.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleFactory
{
    public Role make(final String roleName)
    {
        final Role role = new Role();
        role.setRoleName(roleName);
        return role;
    }
}