package com.quantasnet.qtrack.service;

import com.quantasnet.qtrack.domain.exception.DeleteException;
import com.quantasnet.qtrack.domain.db.Project;
import com.quantasnet.qtrack.domain.repo.ProjectRepo;
import com.quantasnet.qtrack.service.factory.ProjectFactory;
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

    @Resource
    private ProjectFactory projectFactory;

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
    public Project save(final String tag, final String name, final String desc)
    {
        final Project project = projectFactory.make(tag, name, desc);

        return projectRepo.saveAndFlush(project);
    }

    @Override
    public void remove(long projectId)  throws DeleteException
    {
        checkCount(projectId);

        projectRepo.delete(projectId);
    }

    protected void checkCount(long projectId) throws DeleteException
    {
        if(projectRepo.countIssues(projectId) > 0)
        {
            throw new DeleteException("Issues attached to this project still exist.");
        }
    }
}
