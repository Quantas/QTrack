package com.quantasnet.qtrack.domain.repo;

import com.quantasnet.qtrack.domain.db.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepo extends JpaRepository<Project, Long>
{
    @Query("SELECT COUNT(p.id) FROM Project p WHERE p.id = ?1")
    long countIssues(long projectId);
}