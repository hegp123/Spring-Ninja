package com.g2.controller;


import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);

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
        LOGGER.info("INFO");
        LOGGER.warn("WARNING");
        LOGGER.error("ERROR");
        LOGGER.debug("DEBUG");
        model.addAttribute("person", new Person());
        return FORM_VIEW;

    }

    /**
     * para hacer validacion desde el model, por ejemplo nonutll o un numero min y
     * max, etc debemos adicionar @Valid y ademas , BindingResult bindingResult, en
     * el bindingResult van a quedar los errores de las validaciones que no han
     * cumplido
     * 
     * @param person
     * @param bindingResult
     * @return
     */
    @PostMapping("/addperson")
    public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mav.setViewName(FORM_VIEW);

        } else {
            mav.setViewName(RESULT_VIEW);
            mav.addObject("person", person);
        }
        return mav;
    }

}
