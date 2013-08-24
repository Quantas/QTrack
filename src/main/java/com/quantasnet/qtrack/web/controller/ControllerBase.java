package com.quantasnet.qtrack.web.controller;

import com.quantasnet.qtrack.domain.db.User;
import com.quantasnet.qtrack.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

public abstract class ControllerBase
{
    @Resource
    private UserService userService;

    private static final String TEMPLATE = "qtrackTemplate";

    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    protected ModelAndView populateModelAndView(final ModelAndView modelAndView, final String viewName, final String title)
    {
        ModelAndView retModelAndView = modelAndView;

        if (retModelAndView == null)
        {
            retModelAndView = new ModelAndView(TEMPLATE);
        }
        else
        {
            retModelAndView.setViewName(TEMPLATE);
        }

        retModelAndView.addObject("viewName", viewName);
        retModelAndView.addObject("title", title);

        return retModelAndView;
    }

    protected User getCurrentUser()
    {
        return userService.getCurrentUser();
    }
}