package com.quantasnet.qtrack.service;

import com.quantasnet.qtrack.domain.db.Issue;
import com.quantasnet.qtrack.domain.db.IssueStatus;
import com.quantasnet.qtrack.domain.db.Project;
import com.quantasnet.qtrack.domain.db.User;

import java.util.List;

public interface IssueService
{
    List<Issue> findAll();

    List<IssueStatus> findAllStatusTypes();

    List<Issue> findByProject(long projectId);

    List<Issue> findTitleLike(String searchTerm);

    List<Issue> findDescLike(String searchTerm);

    List<Issue> findBothLike(String searchTerm);

    List<Issue> findMostRecent();

    List<Issue> findAssignedToMe(User user);

    Issue findById(long id);

    IssueStatus findStatusById(long id);

    Issue save(Issue issue);

    Issue save(String title, String desc, Project project, IssueStatus issueStatus, User user);

    IssueStatus saveStatus(IssueStatus status);

    void remove(Issue issue);
}