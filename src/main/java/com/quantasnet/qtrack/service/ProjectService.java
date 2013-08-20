package com.quantasnet.qtrack.service;

import com.quantasnet.qtrack.domain.db.Project;
import com.quantasnet.qtrack.domain.exception.DeleteException;

import java.util.List;

public interface ProjectService
{
    public List<Project> findAll();

    Project findById(long id);

    Project save(Project project);

    Project save(String tag, String name, String desc);

    void remove(long projectId) throws DeleteException;
}
