package com.quantasnet.qtrack.web.controller;

import com.quantasnet.qtrack.domain.db.Issue;
import com.quantasnet.qtrack.domain.db.IssueStatus;
import com.quantasnet.qtrack.domain.db.Project;
import com.quantasnet.qtrack.domain.db.User;
import com.quantasnet.qtrack.service.IssueService;
import com.quantasnet.qtrack.service.ProjectService;
import com.quantasnet.qtrack.web.model.IssueStatusEditor;
import com.quantasnet.qtrack.web.model.ProjectEditor;
import org.joda.time.DateTime;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Front end controller for Issues
 * <p>
 * TODO needs pagination
 */
@Controller
@RequestMapping("/issue/**")
public class IssueController extends ControllerBase
{
    private static final String LIST_VIEW = "issueList";

    @Resource
    private IssueService issueService;

    @Resource
    private ProjectService projectService;

    @RequestMapping("/add")
    @Secured("ROLE_USER")
    public ModelAndView add(final ModelAndView modelAndView)
    {
        modelAndView.addObject("issue", new Issue());

        return populateModelAndView(modelAndView, "issueForm", "New Issue");
    }

    @InitBinder
    public void initBinder(final WebDataBinder webDataBinder)
    {
        webDataBinder.registerCustomEditor(IssueStatus.class, new IssueStatusEditor(issueService));
        webDataBinder.registerCustomEditor(Project.class, new ProjectEditor(projectService));
    }

    @ModelAttribute("statusList")
    public Map<Long, String> getStatusList()
    {
        final List<IssueStatus> issueStatusList = issueService.findAllStatusTypes();
        final Map<Long, String> retMap = new TreeMap<Long, String>();

        for (final IssueStatus issueStatus : issueStatusList)
        {
            retMap.put(issueStatus.getId(), issueStatus.getLevelName());
        }

        return retMap;
    }

    @ModelAttribute("projectList")
    public Map<Long, String> getProjectList()
    {
        final List<Project> projectList = projectService.findAll();
        final Map<Long, String> retMap = new TreeMap<Long, String>();

        for (final Project project : projectList)
        {
            retMap.put(project.getId(), project.getProjectTag());
        }

        return retMap;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Secured("ROLE_USER")
    public String save(@ModelAttribute Issue issue)
    {
        final User user = getCurrentUser();
        final DateTime now = DateTime.now();

        issue.setCreatedDate(now);
        issue.setCreatedBy(user);
        issue.setLastModifiedBy(user);
        issue.setLastModifiedDate(now);
        issueService.save(issue);

        return "redirect:/issue/all";
    }

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

        return populateModelAndView(modelAndView, LIST_VIEW, "All Issues");
    }

    @RequestMapping("/project/{projectId}")
    public ModelAndView issuesByProject(final ModelAndView modelAndView, @PathVariable long projectId)
    {
        final List<Issue> issues = issueService.findByProject(projectId);

        modelAndView.addObject("issues", issues);

        return populateModelAndView(modelAndView, LIST_VIEW, "Issues");
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

        return populateModelAndView(modelAndView, LIST_VIEW, "Issues");
    }

    @RequestMapping(value = "/searchDesc", method = RequestMethod.POST)
    public ModelAndView searchDesc(final ModelAndView modelAndView, @RequestParam("searchTerm") String searchTerm)
    {
        final List<Issue> issues = issueService.findDescLike(searchTerm);

        modelAndView.addObject("issues", issues);

        return populateModelAndView(modelAndView, LIST_VIEW, "Issues");
    }

    @RequestMapping(value = "/searchAll", method = RequestMethod.GET)
    public ModelAndView searchAll(final ModelAndView modelAndView, @RequestParam("searchTerm") String searchTerm)
    {
        final List<Issue> issues = issueService.findBothLike(searchTerm);

        modelAndView.addObject("issues", issues);

        return populateModelAndView(modelAndView, LIST_VIEW, "Issues");
    }
}
