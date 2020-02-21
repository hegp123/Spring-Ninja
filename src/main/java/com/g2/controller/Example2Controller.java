package com.g2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {

    public static final String EXAMPLE2_VIEW = "example2";

    // primera forma de hacer request-get
    // localhost:8080/example2/request1?nm=HECTOR&
    @GetMapping("/request1")
    public ModelAndView request1(
            @RequestParam(name = "nm", required = false, defaultValue = "valor por defecto") String name) {
        ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);
        mav.addObject("nm_in_model", name);
        return mav;
    }

    // segunda forma de hacer request-get localhost:8080/example2/request2/HECTOR
    @GetMapping("/request2/{nm}")
    public ModelAndView request2(@PathVariable("nm") String name) {
        ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);
        mav.addObject("nm_in_model", name);
        return mav;
    }

}
