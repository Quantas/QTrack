package com.quantasnet.qtrack.web.controller;

import com.quantasnet.qtrack.domain.db.Role;
import com.quantasnet.qtrack.domain.db.User;
import com.quantasnet.qtrack.service.RoleService;
import com.quantasnet.qtrack.service.UserService;
import com.quantasnet.qtrack.web.model.SignupUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/user/**")
@Controller
public class UserController extends ControllerBase
{
    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/signup")
    public ModelAndView getSignupPage(@RequestParam(value = "error", required = false) boolean error, ModelAndView modelAndView)
    {
        if(error)
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

        if(user.getPassword().equals(signupUser.getConfirmPassword()))
        {
            final User dbUser = userService.findByUsername(user.getUserName());

            if(dbUser == null)
            {
                // Encode the password
                user.setPassword(passwordEncoder.encode(user.getPassword()));

                // Add default Role
                final List<Role> roleList = new ArrayList<Role>();
                final List<Role> dbRoles = roleService.findAll();

                for(final Role role : dbRoles)
                {
                    // TODO get default role somewhere else
                    if(role.getRoleName().equals("ROLE_USER"))
                    {
                        roleList.add(role);
                        break;
                    }
                }

                user.setGravatarHash(userService.generateGravatarHash(user.getEmail()));
                user.setRoles(roleList);
                user.setActive(true);

                userService.save(user);
            }
        }

        return "redirect:/";
    }
}