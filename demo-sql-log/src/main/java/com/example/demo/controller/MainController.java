package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class MainController {
    @GetMapping("/")
    public HashMap index(){
        HashMap result = new HashMap();
        result.put("status","UP");
        return result;
    }
}
