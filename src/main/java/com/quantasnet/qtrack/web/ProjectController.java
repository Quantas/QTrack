package com.quantasnet.qtrack.web;

import com.quantasnet.qtrack.domain.db.Project;
import com.quantasnet.qtrack.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/project/**")
public class ProjectController
{
    @Autowired
    private ProjectService projectService;

    /**
     * Performs a SELECT * FROM project, completely inefficient, needs pagination
     * @param model Spring MVC Model
     * @return projectList view
     */
    @RequestMapping("/all")
    @Secured("ROLE_USER")
    public String all(final Model model)
    {
        final List<Project> projects = projectService.findAll();

        model.addAttribute("projects", projects);

        return "projectList";
    }
}
