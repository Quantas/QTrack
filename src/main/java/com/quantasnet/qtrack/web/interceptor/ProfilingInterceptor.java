package com.quantasnet.qtrack.web.interceptor;

import com.quantasnet.qtrack.profile.Profiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a Spring MVC Method Interceptor.
 * It starts a profiler and profiles the entire call stack through the application.
 *
 * @author quantas
 */
public class ProfilingInterceptor extends HandlerInterceptorAdapter
{
    @Autowired
    private Profiler profiler;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        profiler.start(request.getServletPath());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        profiler.stop();
        profiler.log();
    }
}
