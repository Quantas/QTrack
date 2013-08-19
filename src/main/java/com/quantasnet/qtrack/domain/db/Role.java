package com.quantasnet.qtrack.domain.db;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends AbstractPersistable<Long> implements GrantedAuthority
{
    @Column(name = "role_name")
    private String roleName;

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority()
    {
        return getRoleName();
    }
}