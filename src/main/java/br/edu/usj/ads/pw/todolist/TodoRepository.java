package br.edu.usj.ads.pw.todolist;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findAll();
}
