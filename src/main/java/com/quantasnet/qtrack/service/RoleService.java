package com.quantasnet.qtrack.service;

import com.quantasnet.qtrack.domain.db.Role;

import java.util.List;

public interface RoleService
{
    List<Role> findAll();

    Role save(Role role);

    Role save(String roleName);
}