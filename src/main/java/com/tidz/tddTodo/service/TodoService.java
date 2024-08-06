package com.tidz.tddTodo.service;

import java.util.List;
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

	public List<Todo> getAllTodos() {
		return this.todoRepository.findAll();
	}

	public Todo updateTodo(Todo todo) {
		return this.todoRepository.save(todo);
	}
	
	public void deleteTodoById(Long id) {
		this.todoRepository.deleteById(id);
	}
}
