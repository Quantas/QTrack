package com.quantasnet.qtrack.domain.repo;

import com.quantasnet.qtrack.domain.db.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * TODO pagination
 */
public interface IssueRepo extends JpaRepository<Issue, Long>
{
    List<Issue> findByTitleLike(String searchTerm);
}