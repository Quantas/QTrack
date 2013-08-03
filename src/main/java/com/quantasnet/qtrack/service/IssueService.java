package com.quantasnet.qtrack.service;

import com.quantasnet.qtrack.domain.repo.IssueRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IssueService
{
    @Resource
    private IssueRepo issueRepo;


}
