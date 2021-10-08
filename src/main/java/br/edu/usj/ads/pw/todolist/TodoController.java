package br.edu.usj.ads.pw.todolist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class TodoController {

    List<String> list = new ArrayList<>();

    @GetMapping(value="/")
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todo_list", list);
        return modelAndView;
    }
    

    @PostMapping(value="/add")
    public ModelAndView postAdd(@RequestParam String todo) {
        list.add(todo);

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todo_list", list);
        return modelAndView;
    }
    
    
}
