package com.vienna.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.vienna.controllers.ViennaRoutes.INDEX;
import static com.vienna.controllers.ViennaRoutes.ROOT;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author tonyhui
 * @since 16/11/29
 */
@Controller
public class IndexController {
    @RequestMapping(value = {ROOT, INDEX}, method = GET)
    public String index() {
        return "/index";
    }
}
