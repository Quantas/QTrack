package com.quantasnet.qtrack.service;

import com.quantasnet.qtrack.domain.db.Project;
import com.quantasnet.qtrack.domain.repo.ProjectRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService
{
    @Resource
    private ProjectRepo projectRepo;

    @Override
    public List<Project> findAll()
    {
        return projectRepo.findAll();
    }

    @Override
    public Project findById(long id)
    {
        return projectRepo.findOne(id);
    }

    @Override
    public Project save(Project project)
    {
        return projectRepo.saveAndFlush(project);
    }

    @Override
    public void remove(Project project)
    {
        projectRepo.delete(project);
    }

    @Override
    public void remove(long projectId)
    {
        projectRepo.delete(projectId);
    }
}
