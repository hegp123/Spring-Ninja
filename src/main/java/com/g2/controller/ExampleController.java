package com.g2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.g2.model.Person;

@Controller
@RequestMapping("/example")
public class ExampleController {

    public static final String EXAMPLE_VIEW = "example";

    // primera forma
    // la usamos cuando los datos que se le pasan a la vista son pocos o ninguno
//    @RequestMapping(value = "/exampleString", method = RequestMethod.GET) // esto es lo mismo que el metodo/servicio siguiente
    @GetMapping("/exampleString")
    public String exampleString(Model model) {
        model.addAttribute("name", "exampleString");
        return EXAMPLE_VIEW;
    }

    // segunda forma
    // usada cuando pasamos mucha informacion a la vista
    @GetMapping("/exampleMAV")
    public ModelAndView exampleMAV() {
        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
        mav.addObject("name", "exampleMAV");
        return mav;
    }
    
    @GetMapping("/person")
    public String person(Model model) {
        model.addAttribute("person", new Person("Hector", 36));
        return EXAMPLE_VIEW;
    }
}
