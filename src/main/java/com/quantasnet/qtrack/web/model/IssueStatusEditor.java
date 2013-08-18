package com.quantasnet.qtrack.web.model;

import com.quantasnet.qtrack.domain.db.IssueStatus;
import com.quantasnet.qtrack.service.IssueService;

import java.beans.PropertyEditorSupport;

public class IssueStatusEditor extends PropertyEditorSupport
{
    private final IssueService issueService;

    public IssueStatusEditor(final IssueService issueService)
    {
        this.issueService = issueService;
    }

    @Override
    public void setAsText(final String text) throws IllegalArgumentException
    {
        final long id = Long.parseLong(text);
        final IssueStatus status = issueService.findStatusById(id);

        setValue(status);
    }

    @Override
    public String getAsText()
    {
        final IssueStatus status = (IssueStatus) getValue();
        return status == null ? "" : status.getLevelName();
    }
}