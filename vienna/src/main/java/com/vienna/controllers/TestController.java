package com.vienna.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tonyhui
 * @since 16/9/7
 */
@Controller
public class TestController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
