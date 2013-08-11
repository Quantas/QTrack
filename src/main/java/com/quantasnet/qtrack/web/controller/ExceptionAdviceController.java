package com.quantasnet.qtrack.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionAdviceController extends ControllerBase
{
    @ExceptionHandler(UnsupportedOperationException.class)
    public ModelAndView handleUnsupportedOp(UnsupportedOperationException ex)
    {
        LOG.info("Handling NYI", ex);
        return errorModelAndView(ex);
    }

    private ModelAndView errorModelAndView(Exception ex)
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exception");
        modelAndView.addObject("name", ex.getClass().getSimpleName());

        return modelAndView;
    }
}