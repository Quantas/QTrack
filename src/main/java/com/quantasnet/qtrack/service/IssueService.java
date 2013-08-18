package com.quantasnet.qtrack.service;

import com.quantasnet.qtrack.domain.db.Issue;
import com.quantasnet.qtrack.domain.db.IssueStatus;

import java.util.List;

public interface IssueService
{
    List<Issue> findAll();

    List<IssueStatus> findAllStatusTypes();

    List<Issue> findByProject(long projectId);

    List<Issue> findTitleLike(String searchTerm);

    List<Issue> findDescLike(String searchTerm);

    List<Issue> findBothLike(String searchTerm);

    Issue findById(long id);

    IssueStatus findStatusById(long id);

    Issue save(Issue issue);

    void remove(Issue issue);
}