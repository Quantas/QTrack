package com.quantasnet.qtrack.web.security;

import com.quantasnet.qtrack.domain.db.User;
import com.quantasnet.qtrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityInterceptor extends HandlerInterceptorAdapter
{
    @Autowired
    private UserService userService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        if(modelAndView != null)
        {
            modelAndView.addObject("loggedInUser", getCurrentUser());
        }
    }

    private User getCurrentUser()
    {
        return userService.getCurrentUser();
    }
}