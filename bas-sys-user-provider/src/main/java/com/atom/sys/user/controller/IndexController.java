package com.atom.sys.user.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {


    /***
     * 首页
     *
     * @return
     */
    @RequestMapping("/")
    public Object index(Model model){


        return null;
    }






}
