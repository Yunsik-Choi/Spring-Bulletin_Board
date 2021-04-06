package com.bulletin.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    @ResponseBody
    public String home(){
        return "<h1>Hello</h1>";
    }

}
