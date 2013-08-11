package com.quantasnet.qtrack.web.controller;

import com.quantasnet.qtrack.domain.db.Issue;
import com.quantasnet.qtrack.service.IssueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
     * @param model Spring MVC Model
     * @return issueList view
     */
    @RequestMapping("/all")
    public String all(final Model model)
    {
        final List<Issue> issues = issueService.findAll();

        model.addAttribute("issues", issues);

        return "issueList";
    }

    @RequestMapping("/project/{projectId}")
    public String issuesByProject(final Model model, @PathVariable long projectId)
    {
        final List<Issue> issues = issueService.findByProject(projectId);

        model.addAttribute("issues", issues);

        return "issueList";
    }

    /**
     * Performs a SELECT statement using the searchTerm in-between % characters<br />
     * This may be inefficient and should be addressed
     * @param model Spring MVC Model
     * @param searchTerm Text to search for
     * @return issueList View
     */
    @RequestMapping(value = "/searchTitle", method = RequestMethod.POST)
    public String searchTitle(final Model model, @RequestParam("searchTerm") String searchTerm)
    {
        final List<Issue> issues = issueService.findTitleLike(searchTerm);

        model.addAttribute("issues", issues);

        return "issueList";
    }

    @RequestMapping(value = "/searchDesc", method = RequestMethod.POST)
    public String searchDesc(final Model model, @RequestParam("searchTerm") String searchTerm)
    {
        final List<Issue> issues = issueService.findDescLike(searchTerm);

        model.addAttribute("issues", issues);

        return "issueList";
    }

    @RequestMapping(value = "/searchAll", method = RequestMethod.GET)
    public String searchAll(final Model model, @RequestParam("searchTerm") String searchTerm)
    {
        final List<Issue> issues = issueService.findBothLike(searchTerm);

        model.addAttribute("issues", issues);

        return "issueList";
    }
}
