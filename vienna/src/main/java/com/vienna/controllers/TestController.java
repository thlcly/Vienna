package com.vienna.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tonyhui
 * @since 16/9/7
 */
@Controller
@RestController
public class TestController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
