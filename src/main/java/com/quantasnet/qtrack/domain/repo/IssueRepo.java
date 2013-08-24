package com.quantasnet.qtrack.domain.repo;

import com.quantasnet.qtrack.domain.db.Issue;
import com.quantasnet.qtrack.domain.db.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

/**
 * TODO pagination
 */
public interface IssueRepo extends JpaRepository<Issue, Long>
{
    List<Issue> findByProject_Id(Long projectId);

    List<Issue> findByTitleLike(String searchTerm);

    List<Issue> findByDescLike(String searchTerm);

    List<Issue> findByTitleLikeOrDescLike(String title, String desc);

    @Query("SELECT i FROM Issue i ORDER BY i.lastModifiedDate DESC")
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    List<Issue> findMostRecent(Pageable pageable);

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    List<Issue> findByAssignedToNotNullAndAssignedTo(User assignedTo);
}