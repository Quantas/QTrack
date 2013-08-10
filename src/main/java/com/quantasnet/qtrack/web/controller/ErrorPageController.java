package com.quantasnet.qtrack.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController
{
    @RequestMapping("/404")
    public String notFound()
    {
        return "404";
    }
}