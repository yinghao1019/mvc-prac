package com.demo.mvc_prac.controller;

import com.demo.mvc_prac.model.entity.StudentEntity;
import com.demo.mvc_prac.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class HelloController {
    private final StudentService service;

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String hello(Model model) {
        model.addAttribute("students", service.findStudent());
        return "hello";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public String list(Model model) {
        model.addAttribute("resultList", service.findStudent());
        return "list";
    }

    @RequestMapping(value = "view", method = RequestMethod.POST)
    public ModelAndView view(@RequestParam long id, @RequestParam String type) {
        StudentEntity student = service.findStudent(id);
        ModelAndView model = new ModelAndView();
        model.setViewName("view");
        model.addObject("s", student);
        model.addObject("type", type);
        return model;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ModelAndView update(
            @ModelAttribute("s") StudentEntity student, RedirectAttributes attr) {
        service.updateStudent(student);
        attr.addFlashAttribute("message", "修改成功");
        return new ModelAndView("redirect:hello");
    }
}
