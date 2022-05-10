package com.mms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DefaultController {

    @GetMapping(value = {""}, produces ={"text/html"})
    public String index(HttpServletRequest req) {
        return "index.html";
    }
}
