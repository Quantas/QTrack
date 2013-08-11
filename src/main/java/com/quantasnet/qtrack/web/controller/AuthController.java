package com.quantasnet.qtrack.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth/**")
public class AuthController extends ControllerBase
{
    /**
     * Handles and retrieves the login JSP page
     *
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam(value = "error", required = false) boolean error, ModelAndView modelAndView)
    {
        // Add an error message to the model if login is unsuccessful
        // The 'error' parameter is set to true based on the when the authentication has failed.
        // We declared this under the authentication-failure-url attribute inside the spring-security.xml
        if (error)
        {
            // Assign an error message
            modelAndView.addObject("error", "You have entered an invalid username or password!");
        }

        return populateModelAndView(modelAndView, "login", "Login");
    }

    /**
     * Handles and retrieves the denied JSP page. This is shown whenever a regular user
     * tries to access an admin only page.
     *
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public ModelAndView getDeniedPage()
    {
        return populateModelAndView(null, "accessdenied", "Access Denied");
    }
}