package com.quantasnet.qtrack.web.controller;

import com.quantasnet.qtrack.domain.db.Issue;
import com.quantasnet.qtrack.domain.db.Project;
import com.quantasnet.qtrack.service.IssueService;
import com.quantasnet.qtrack.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DashboardController extends ControllerBase
{
    @Resource
    private ProjectService projectService;

    @Resource
    private IssueService issueService;

    @RequestMapping(value = {"/dashboard", "/"})
    public ModelAndView index(final ModelAndView modelAndView)
    {
        final List<Project> projects = projectService.findAll();
        modelAndView.addObject("projects", projects);

        final List<Issue> issues = issueService.findMostRecent();
        modelAndView.addObject("issues", issues);

        final List<Issue> myIssues = issueService.findAssignedToMe(getCurrentUser());
        modelAndView.addObject("myIssues", myIssues);

        return populateModelAndView(modelAndView, "dashboard", "Dashboard");
    }
}