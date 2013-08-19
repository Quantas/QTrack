package com.quantasnet.qtrack.domain.repo;

import com.quantasnet.qtrack.domain.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>
{
    User findOneByUserName(final String userName);
}