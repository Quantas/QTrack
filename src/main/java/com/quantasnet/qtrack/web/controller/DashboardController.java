package com.quantasnet.qtrack.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController extends ControllerBase
{
    @RequestMapping(value = {"/dashboard", "/"})
    public ModelAndView index()
    {
        return populateModelAndView(null, "dashboard", "Dashboard");
    }
}