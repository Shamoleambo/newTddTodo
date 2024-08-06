package com.tidz.tddTodo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tidz.tddTodo.entity.Todo;
import com.tidz.tddTodo.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;

	public Todo addTodo(Todo todo) {
		return this.todoRepository.save(todo);
	}

	public Optional<Todo> getTodoById(Long id) {
		return this.todoRepository.findById(id);
	}
}
