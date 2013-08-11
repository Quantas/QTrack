package com.quantasnet.qtrack.service;

import com.quantasnet.qtrack.domain.DeleteException;
import com.quantasnet.qtrack.domain.db.Project;

import java.util.List;

public interface ProjectService
{
    public List<Project> findAll();

    Project findById(long id);

    Project save(Project project);

    void remove(long projectId) throws DeleteException;
}
