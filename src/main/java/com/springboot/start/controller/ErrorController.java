package com.springboot.start.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author liuxian
 * @Date 2018/6/5
 * @Desc
 */
@Controller
@EnableAutoConfiguration
public class ErrorController {
    @RequestMapping("/errorPage")
    @ResponseBody
    String error() {
        return "Error!";
    }
}
