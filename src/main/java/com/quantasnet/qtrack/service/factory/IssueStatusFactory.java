package com.quantasnet.qtrack.service.factory;

import com.quantasnet.qtrack.domain.db.IssueStatus;
import org.springframework.stereotype.Service;

@Service
public class IssueStatusFactory
{
    public IssueStatus make(final String levelName)
    {
        final IssueStatus issueStatus = new IssueStatus();
        issueStatus.setLevelName(levelName);

        return issueStatus;
    }
}