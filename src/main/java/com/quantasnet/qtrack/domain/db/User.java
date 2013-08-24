package com.quantasnet.qtrack.domain.db;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class User extends AbstractPersistable<Long> implements UserDetails
{
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_first_name", nullable = false)
    private String firstName;

    @Column(name = "user_last_name", nullable = false)
    private String lastName;

    @Column(name = "user_email", nullable = false, unique = true)
    private String email;

    @Column(name = "user_gravatar_hash")
    private String gravatarHash;

    @Column(name = "user_active", nullable = false)
    private boolean active;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    List<Role> roles;

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getGravatarHash()
    {
        return gravatarHash;
    }

    public void setGravatarHash(String gravatarHash)
    {
        this.gravatarHash = gravatarHash;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public List<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(List<Role> roles)
    {
        this.roles = roles;
    }

    // UserDetails methods

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return getRoles();
    }

    @Override
    public String getUsername()
    {
        return getUserName();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        // No-op
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        // No-op
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        // No-op
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return isActive();
    }
}