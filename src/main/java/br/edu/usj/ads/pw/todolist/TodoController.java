package br.edu.usj.ads.pw.todolist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class TodoController {

    // List<String> list = new ArrayList<>();

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
    public String postAdd(@RequestParam String todo) {
        //list.add(todo);

        Todo newTodo = new Todo();
        newTodo.setDescription(todo);

        todoRepository.save(newTodo);

        return "redirect:/";
    }
    
    
}
