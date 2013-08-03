package com.quantasnet.qtrack.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController
{
    @RequestMapping("/404")
    public String notFound()
    {
        return "404";
    }
}
