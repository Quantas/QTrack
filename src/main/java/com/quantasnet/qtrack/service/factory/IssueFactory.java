package com.quantasnet.qtrack.service.factory;

import com.quantasnet.qtrack.domain.db.Issue;
import com.quantasnet.qtrack.domain.db.IssueStatus;
import com.quantasnet.qtrack.domain.db.Project;
import com.quantasnet.qtrack.domain.db.User;
import com.quantasnet.qtrack.service.UserService;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public final class IssueFactory
{
    @Resource
    private UserService userService;

    public Issue makeWithUser(final String title, final String desc, final Project project, final IssueStatus issueStatus, final User user)
    {
        final DateTime now = DateTime.now();
        final Issue issue = new Issue();

        issue.setTitle(title);
        issue.setDesc(desc);
        issue.setProject(project);
        issue.setIssueStatus(issueStatus);
        issue.setCreatedDate(now);
        issue.setCreatedBy(user);
        issue.setLastModifiedDate(now);
        issue.setLastModifiedBy(user);

        return issue;
    }

    public Issue makeFromWeb(final Issue issue)
    {
        final DateTime now = DateTime.now();
        final User user = userService.getCurrentUser();

        issue.setCreatedDate(now);
        issue.setCreatedBy(user);
        issue.setLastModifiedDate(now);
        issue.setLastModifiedBy(user);

        return issue;
    }
}