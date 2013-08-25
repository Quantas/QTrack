package com.quantasnet.qtrack.web.controller;

import com.quantasnet.qtrack.domain.db.User;
import com.quantasnet.qtrack.service.UserService;
import com.quantasnet.qtrack.web.model.SignupUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;

@RequestMapping("/user/**")
@Controller
public class UserController extends ControllerBase
{
    private static final String MODEL_OBJ = "signupUser";
    private static final String SIGNUP_FORM = "signup";
    private static final String SIGNUP_TITLE = "Sign Up";

    @Resource
    private UserService userService;

    @RequestMapping("/signup")
    public ModelAndView getSignupPage(@RequestParam(value = "error", required = false) boolean error, ModelAndView modelAndView)
    {
        if (error)
        {
            modelAndView.addObject("error", "Signup Error");
        }

        modelAndView.addObject(MODEL_OBJ, new SignupUser());

        return populateModelAndView(modelAndView, SIGNUP_FORM, SIGNUP_TITLE);
    }

    @RequestMapping("/save")
    public ModelAndView saveUser(@Valid SignupUser signupUser, BindingResult result, ModelAndView modelAndView)
    {
        checkPasswordMatch(signupUser, result);

        checkExistingUserName(signupUser, result);

        checkExistingEmail(signupUser, result);

        if(result.hasErrors())
        {
            modelAndView.addObject(MODEL_OBJ, signupUser);
            addErrorMessage(modelAndView, "There was an error, please see below for specifics");
            return populateModelAndView(modelAndView, SIGNUP_FORM, SIGNUP_TITLE);
        }

        saveNewUser(signupUser);

        final ModelAndView redirectView = populateModelAndView(null, "login", "Log In");
        addInfoMessage(modelAndView, "Signup Successful, please login now.");
        return redirectView;
    }

    private void saveNewUser(final SignupUser signupUser)
    {
        final User webUser = new User();
        webUser.setUserName(signupUser.getUserName());
        webUser.setPassword(signupUser.getPassword());
        webUser.setEmail(signupUser.getEmail());
        webUser.setFirstName(signupUser.getFirstName());
        webUser.setLastName(signupUser.getLastName());
        userService.save(webUser);
    }

    private void checkPasswordMatch(final SignupUser signupUser, final BindingResult result)
    {
        if(!signupUser.getPassword().equals(signupUser.getConfirmPassword()))
        {
            result.addError(new FieldError(MODEL_OBJ, "confirmPassword", "confirm password must match password"));
        }
    }

    private void checkExistingUserName(final SignupUser signupUser, final BindingResult result)
    {
        final User existingUser = userService.findByUsername(signupUser.getUserName());

        if(existingUser != null)
        {
            result.addError(new FieldError(MODEL_OBJ, "userName", "already taken"));
        }
    }

    private void checkExistingEmail(final SignupUser signupUser, final BindingResult result)
    {
        final User existingUserByEmail = userService.findByEmail(signupUser.getEmail());

        if(existingUserByEmail != null)
        {
            result.addError(new FieldError(MODEL_OBJ, "email", "already in use"));
        }
    }
}