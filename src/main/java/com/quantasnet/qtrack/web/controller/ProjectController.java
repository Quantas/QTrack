package com.quantasnet.qtrack.web.controller;

import com.quantasnet.qtrack.domain.exception.DeleteException;
import com.quantasnet.qtrack.domain.db.Project;
import com.quantasnet.qtrack.service.ProjectService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/project/**")
public class ProjectController extends ControllerBase
{
    @Resource
    private ProjectService projectService;

    /**
     * Performs a SELECT * FROM project, completely inefficient, needs pagination
     * @param modelAndView Spring MVC Model
     * @return projectList view
     */
    @RequestMapping("/all")
    @Secured("ROLE_USER")
    public ModelAndView all(final ModelAndView modelAndView)
    {
        final List<Project> projects = projectService.findAll();

        modelAndView.addObject("projects", projects);

        return populateModelAndView(modelAndView, "projectList", "All Projects");
    }

    @RequestMapping("/add")
    @Secured("ROLE_ADMIN")
    public ModelAndView add(final ModelAndView modelAndView)
    {
        modelAndView.addObject("project", new Project());

        return populateModelAndView(modelAndView, "projectForm", "New Project");
    }

    @RequestMapping("/edit/{projectId}")
    @Secured("ROLE_ADMIN")
    public ModelAndView edit(final ModelAndView modelAndView, @PathVariable long projectId)
    {
        final Project project = projectService.findById(projectId);

        modelAndView.addObject("project", project);

        return populateModelAndView(modelAndView, "projectForm", "Editing - " + project.getProjectName());
    }

    @RequestMapping("/delete/{projectId}")
    @Secured("ROLE_ADMIN")
    public ModelAndView delete(@PathVariable long projectId, final RedirectAttributes redirectAttributes)
    {
        final ModelAndView modelAndView = new ModelAndView("redirect:/project/all");

        try
        {
            projectService.remove(projectId);
        }
        catch(DeleteException de)
        {
            final String message = de.getMessage();

            redirectAttributes.addFlashAttribute("error", message);

            LOG.error(message);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Secured("ROLE_ADMIN")
    public String save(@ModelAttribute Project project)
    {
        projectService.save(project);

        return "redirect:/project/all";
    }
}