package com.quantasnet.qtrack.domain.repo;

import com.quantasnet.qtrack.domain.db.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepo extends JpaRepository<Issue, Long>
{

}