package com.quantasnet.qtrack.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfilingInterceptor extends HandlerInterceptorAdapter
{
    private final Logger logger = LoggerFactory.getLogger(ProfilingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        Profiler profiler = new Profiler("Web");
        profiler.setLogger(logger);
        profiler.start("MVC - " + request.getServletPath());

        request.setAttribute("profiler", profiler);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        Profiler profiler = (Profiler)request.getAttribute("profiler");

        profiler.stop().print();
    }
}
