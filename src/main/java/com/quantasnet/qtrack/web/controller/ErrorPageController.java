package com.quantasnet.qtrack.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorPageController extends ControllerBase
{
    @RequestMapping("/404")
    public ModelAndView notFound()
    {
        return populateModelAndView(null, "404", "404");
    }
}