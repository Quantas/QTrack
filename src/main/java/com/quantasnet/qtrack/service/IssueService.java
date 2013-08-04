package com.quantasnet.qtrack.service;

import com.quantasnet.qtrack.domain.db.Issue;

import java.util.List;

public interface IssueService
{
    List<Issue> findAll();

    List<Issue> findTitleLike(String searchTerm);

    List<Issue> findDescLike(String searchTerm);

    List<Issue> findBothLike(String searchTerm);

    Issue findById(long id);

    Issue save(Issue issue);

    void remove(Issue issue);
}