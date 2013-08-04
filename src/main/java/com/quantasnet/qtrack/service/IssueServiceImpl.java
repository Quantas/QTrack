package com.quantasnet.qtrack.service;

import com.quantasnet.qtrack.domain.db.Issue;
import com.quantasnet.qtrack.domain.repo.IssueRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class IssueServiceImpl implements IssueService
{
    @Resource
    private IssueRepo issueRepo;

    @Override
    public List<Issue> findAll()
    {
        return issueRepo.findAll();
    }

    @Override
    public List<Issue> findTitleLike(final String searchTerm)
    {
        return issueRepo.findByTitleLike('%' + searchTerm + '%');
    }

    @Override
    public List<Issue> findDescLike(final String searchTerm)
    {
        return issueRepo.findByDescLike('%' + searchTerm + '%');
    }

    @Override
    public List<Issue> findBothLike(final String searchTerm)
    {
        final String wildcardSearch = '%' + searchTerm + '%';

        return issueRepo.findByTitleLikeOrDescLike(wildcardSearch, wildcardSearch);
    }

    @Override
    public Issue findById(final long id)
    {
        return issueRepo.findOne(id);
    }

    @Override
    public Issue save(Issue issue)
    {
        return issueRepo.saveAndFlush(issue);
    }

    @Override
    public void remove(Issue issue)
    {
        issueRepo.delete(issue);
    }
}