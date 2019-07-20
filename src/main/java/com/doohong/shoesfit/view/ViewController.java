package com.doohong.shoesfit.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping(value="/")
    public String main(){
        return "index";
    }
    @GetMapping(value="/test")
    public String test(){
        return "test";
    }

}
