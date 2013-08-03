package com.quantasnet.qtrack.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionAdviceController
{
    private final Logger log = LoggerFactory.getLogger(ExceptionAdviceController.class);

    @ExceptionHandler(UnsupportedOperationException.class)
    public ModelAndView handleUnsupportedOp(UnsupportedOperationException ex)
    {
        log.info("Handling NYI", ex);
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