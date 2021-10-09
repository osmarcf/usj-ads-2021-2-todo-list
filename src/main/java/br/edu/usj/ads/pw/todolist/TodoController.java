package br.edu.usj.ads.pw.todolist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoController {
    @Autowired
    TodoRepository todoRepository;

    @GetMapping(value="/")
    public ModelAndView getIndex() {
        List<Todo> list = todoRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todo_list", list);
        return modelAndView;
    }

    @PostMapping(value="/add")
    public String postAdd(Todo todo) {
        todoRepository.save(todo);
        return "redirect:/";
    }
}
