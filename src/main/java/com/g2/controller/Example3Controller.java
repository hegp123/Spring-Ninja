package com.g2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.g2.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

    private static final String FORM_VIEW = "form";
    private static final String RESULT_VIEW = "result";

    // redireccion
    @GetMapping()
    public String redirect() {
        return redirect1();
    }
    
 // redireccion, esto hace lo mismo que el metodo rediretView
//    @GetMapping("/")
    public String redirect1() {
        return "redirect:/example3/showform";
    }
    
    @GetMapping("/")
    public RedirectView rediretView() {
        return new RedirectView("/example3/showform");
    }
    
    @GetMapping("/showform")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        int s = 2/0;
        return FORM_VIEW;

    }
    @PostMapping("/addperson")
    public ModelAndView addPerson(@ModelAttribute("person") Person person) {
        ModelAndView mav = new ModelAndView(RESULT_VIEW);
        mav.addObject("person", person);
        return mav;
    }

}
