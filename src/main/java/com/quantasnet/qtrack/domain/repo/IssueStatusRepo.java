package com.quantasnet.qtrack.domain.repo;

import com.quantasnet.qtrack.domain.db.IssueStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueStatusRepo extends JpaRepository<IssueStatus, Long>
{

}