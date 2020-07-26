package com.gw.springboot_websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author GuoWei qq:1677488547
 * @version 1.0
 * @date 2020/7/26 21:04
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    String indexController(){
        return "index";
    }
}
