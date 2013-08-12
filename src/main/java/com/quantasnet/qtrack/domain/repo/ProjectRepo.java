package com.quantasnet.qtrack.domain.repo;

import com.quantasnet.qtrack.domain.db.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepo extends JpaRepository<Project, Long>
{
    @Query("SELECT COUNT(i.id) FROM Issue i WHERE i.project.id = ?1")
    long countIssues(long projectId);
}