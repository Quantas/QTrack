package com.quantasnet.qtrack.service;

import com.quantasnet.qtrack.domain.db.Role;
import com.quantasnet.qtrack.domain.repo.RoleRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService
{
    @Resource
    private RoleRepo roleRepo;

    @Override
    public List<Role> findAll()
    {
        return roleRepo.findAll();
    }

    @Override
    public Role save(Role role)
    {
        return roleRepo.saveAndFlush(role);
    }
}