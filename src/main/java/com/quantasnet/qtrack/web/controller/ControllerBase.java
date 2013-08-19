package com.quantasnet.qtrack.web.controller;

import com.quantasnet.qtrack.domain.db.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

public abstract class ControllerBase
{
    protected static final String TEMPLATE = "qtrackTemplate";

    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    protected ModelAndView populateModelAndView(final ModelAndView modelAndView, final String viewName, final String title)
    {
        ModelAndView retModelAndView = modelAndView;

        if(retModelAndView == null)
        {
            retModelAndView = new ModelAndView(TEMPLATE);
        }
        else
        {
            retModelAndView.setViewName(TEMPLATE);
        }

        retModelAndView.addObject("loggedInUser", getCurrentUser());
        retModelAndView.addObject("viewName", viewName);
        retModelAndView.addObject("title", title);

        return retModelAndView;
    }

    protected User getCurrentUser()
    {
        final Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(user instanceof User)
        {
            return (User)user;
        }
        else
        {
            return null;
        }
    }
}