package com.quantasnet.qtrack.web.model;

import com.quantasnet.qtrack.domain.db.Project;
import com.quantasnet.qtrack.service.ProjectService;

import java.beans.PropertyEditorSupport;

public class ProjectEditor extends PropertyEditorSupport
{
    private final ProjectService projectService;

    public ProjectEditor(final ProjectService projectService)
    {
        this.projectService = projectService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        final long id = Long.parseLong(text);
        final Project project = projectService.findById(id);
        setValue(project);
    }

    @Override
    public String getAsText()
    {
        final Project project = (Project) getValue();
        return project == null ? "" : project.getProjectTag();
    }
}