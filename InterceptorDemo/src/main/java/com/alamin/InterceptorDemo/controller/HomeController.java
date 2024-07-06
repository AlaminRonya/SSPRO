package com.alamin.InterceptorDemo.controller;

import com.alamin.InterceptorDemo.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private RequestRepository repository;
    @GetMapping("/index")
    public String index() {
        return "index";
    }
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
    @ResponseBody
    @GetMapping("/analytics/request-stat")
    public List<?> starts(){
        return repository.getTrackers();
    }
}
