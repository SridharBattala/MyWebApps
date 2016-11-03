package com.sree.leave.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UIController {
    @RequestMapping(value="/ui",method = RequestMethod.GET)
   
     public String homepage(){
    
            return "index.html";
    
        }
    
    }


