package com.g2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.g2.component.ExampleComponent;
import com.g2.model.Person;
import com.g2.service.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleController {

    public static final String EXAMPLE_VIEW = "example";

    @Autowired
    @Qualifier("exampleService")
    private ExampleService exampleService;

    @Autowired // indica a spring que vamos a inyectar un componente que esta en su memoria
    @Qualifier("exampleComponent") // indica a sprint el nombre del bean que esta en su memoria
    private ExampleComponent exampleComponent;

    // primera forma
    // la usamos cuando los datos que se le pasan a la vista son pocos o ninguno
//    @RequestMapping(value = "/exampleString", method = RequestMethod.GET) // esto es lo mismo que el metodo/servicio siguiente
    @GetMapping("/exampleString")
    public String exampleString(Model model) {
        model.addAttribute("name", "exampleString");
        model.addAttribute("person", new Person("Hector", 36));
        model.addAttribute("people", exampleService.getListPeople());
        return EXAMPLE_VIEW;
    }

    // segunda forma
    // usada cuando pasamos mucha informacion a la vista
    @GetMapping("/exampleMAV")
    public ModelAndView exampleMAV() {
        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
        mav.addObject("name", "exampleMAV");
        mav.addObject("person", new Person("Hector", 36));
        mav.addObject("people", exampleService.getListPeople());
        return mav;
    }

    @GetMapping("/person")
    public String person(Model model) {
        model.addAttribute("person", new Person("Hector", 36));
        return EXAMPLE_VIEW;
    }

    @GetMapping("/people")
    public ModelAndView people() {
        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
        mav.addObject("name", "people");
        mav.addObject("person", new Person("Hector", 36));
        mav.addObject("people", exampleService.getListPeople());
        exampleComponent.sayHello();
        return mav;
    }

}
