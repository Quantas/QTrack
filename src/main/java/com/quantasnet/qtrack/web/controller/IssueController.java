package com.quantasnet.qtrack.web.controller;

import com.quantasnet.qtrack.domain.db.Issue;
import com.quantasnet.qtrack.service.IssueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Front end controller for Issues
 * <p>
 * TODO needs pagination
 */
@Controller
@RequestMapping("/issue/**")
public class IssueController extends ControllerBase
{
    @Resource
    private IssueService issueService;

    /**
     * Performs a SELECT * FROM issue, completely inefficient, needs pagination
     * @param modelAndView Spring MVC Model
     * @return issueList view
     */
    @RequestMapping("/all")
    public ModelAndView all(final ModelAndView modelAndView)
    {
        final List<Issue> issues = issueService.findAll();

        modelAndView.addObject("issues", issues);

        return populateModelAndView(modelAndView, "issueList", "All Issues");
    }

    @RequestMapping("/project/{projectId}")
    public ModelAndView issuesByProject(final ModelAndView modelAndView, @PathVariable long projectId)
    {
        final List<Issue> issues = issueService.findByProject(projectId);

        modelAndView.addObject("issues", issues);

        return populateModelAndView(modelAndView, "issueList", "Issues");
    }

    /**
     * Performs a SELECT statement using the searchTerm in-between % characters<br />
     * This may be inefficient and should be addressed
     * @param modelAndView Spring MVC Model
     * @param searchTerm Text to search for
     * @return issueList View
     */
    @RequestMapping(value = "/searchTitle", method = RequestMethod.POST)
    public ModelAndView searchTitle(final ModelAndView modelAndView, @RequestParam("searchTerm") String searchTerm)
    {
        final List<Issue> issues = issueService.findTitleLike(searchTerm);

        modelAndView.addObject("issues", issues);

        return populateModelAndView(modelAndView, "issueList", "Issues");
    }

    @RequestMapping(value = "/searchDesc", method = RequestMethod.POST)
    public ModelAndView searchDesc(final ModelAndView modelAndView, @RequestParam("searchTerm") String searchTerm)
    {
        final List<Issue> issues = issueService.findDescLike(searchTerm);

        modelAndView.addObject("issues", issues);

        return populateModelAndView(modelAndView, "issueList", "Issues");
    }

    @RequestMapping(value = "/searchAll", method = RequestMethod.GET)
    public ModelAndView searchAll(final ModelAndView modelAndView, @RequestParam("searchTerm") String searchTerm)
    {
        final List<Issue> issues = issueService.findBothLike(searchTerm);

        modelAndView.addObject("issues", issues);

        return populateModelAndView(modelAndView, "issueList", "Issues");
    }
}
