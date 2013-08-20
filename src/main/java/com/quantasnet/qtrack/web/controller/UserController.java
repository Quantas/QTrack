package com.quantasnet.qtrack.web.controller;

import com.quantasnet.qtrack.domain.db.User;
import com.quantasnet.qtrack.service.UserService;
import com.quantasnet.qtrack.web.model.SignupUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@RequestMapping("/user/**")
@Controller
public class UserController extends ControllerBase
{
    @Resource
    private UserService userService;

    @RequestMapping("/signup")
    public ModelAndView getSignupPage(@RequestParam(value = "error", required = false) boolean error, ModelAndView modelAndView)
    {
        if (error)
        {
            modelAndView.addObject("error", "Signup Error");
        }

        modelAndView.addObject("user", new SignupUser());

        return populateModelAndView(modelAndView, "signup", "Sign Up");
    }

    @RequestMapping("/save")
    public String saveUser(@ModelAttribute SignupUser signupUser)
    {
        final User user = signupUser.getUser();

        if (user.getPassword().equals(signupUser.getConfirmPassword()))
        {
            userService.save(user);
        }

        return "redirect:/";
    }
}