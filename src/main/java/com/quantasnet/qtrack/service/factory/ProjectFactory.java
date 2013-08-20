package com.quantasnet.qtrack.service.factory;

import com.quantasnet.qtrack.domain.db.Project;
import org.springframework.stereotype.Service;

@Service
public final class ProjectFactory
{
    public Project make(final String tag, final String name, final String desc)
    {
        final Project project = new Project();
        project.setProjectTag(tag);
        project.setProjectName(name);
        project.setProjectDesc(desc);

        return project;
    }
}