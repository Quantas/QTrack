package com.quantasnet.qtrack.domain.repo;

import com.quantasnet.qtrack.domain.db.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;

public interface UserRepo extends JpaRepository<User, Long>
{
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    User findOneByUserName(final String userName);
}