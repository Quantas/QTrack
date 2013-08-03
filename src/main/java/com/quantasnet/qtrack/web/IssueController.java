package com.quantasnet.qtrack.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/issue/**")
public class IssueController
{
    @RequestMapping("/env")
    public String index(final Model model)
    {
        model.addAttribute("envs", System.getenv());

        return "env";
    }
}
