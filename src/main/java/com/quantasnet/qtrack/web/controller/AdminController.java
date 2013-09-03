package com.quantasnet.qtrack.web.controller;

import com.quantasnet.qtrack.domain.db.User;
import com.quantasnet.qtrack.service.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/admin/**")
@Secured("ROLE_ADMIN")
@Controller
public class AdminController extends ControllerBase
{
    @Resource
    private UserService userService;

    @RequestMapping("/user/list")
    public ModelAndView userList(ModelAndView modelAndView)
    {
        final List<User> users = userService.findAll();
        modelAndView.addObject("users", users);

        return populateModelAndView(modelAndView, "adminUsers", "Admin | Users");
    }
}