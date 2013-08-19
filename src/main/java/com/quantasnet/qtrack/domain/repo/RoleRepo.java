package com.quantasnet.qtrack.domain.repo;

import com.quantasnet.qtrack.domain.db.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long>
{

}