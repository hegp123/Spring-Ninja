package com.g2.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.g2.entity.Course;
import com.g2.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private static final Log LOGGER = LogFactory.getLog(CourseController.class);

    private static final String COURSES_VIEW = "course/courses";

    @Autowired
    @Qualifier("courseService")
    private CourseService courseService;

    @GetMapping("/listcourses")
    public ModelAndView listAllCourses() {
        LOGGER.info("call: listAllCourses()");
        ModelAndView mav = new ModelAndView(COURSES_VIEW);

        mav.addObject("courses", courseService.listAllCourses());
        //esta linea de abajo se coloca porque en la vista a parte del listado de cursos mas abajito esta un form
        // este form contiene un objeto curso 'th:object="${course}" ' para crear un curso, y si esto es null, se totea la app
        mav.addObject("course", new Course());
        
        return mav;
    }

    @PostMapping("/addcourse")
    public String addCourse(@ModelAttribute("course") Course course) {
        LOGGER.info("call: addCourse()" + " -- params: " + course.toString());
        courseService.addCourse(course);
        return "redirect:/courses/listcourses";
    }

}
