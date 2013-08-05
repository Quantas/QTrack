package com.quantasnet.qtrack.domain.repo;

import com.quantasnet.qtrack.domain.db.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long>
{
    // using built in methods for now
}
