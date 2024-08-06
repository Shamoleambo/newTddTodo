package com.tidz.tddTodo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tidz.tddTodo.entity.Todo;
import com.tidz.tddTodo.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping
	public List<Todo> getAllTodos() {
		return this.todoService.getAllTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
		Optional<Todo> todo = this.todoService.getTodoById(id);
		return todo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public Todo addTodo(@RequestBody Todo todo) {
		return this.todoService.addTodo(todo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
		Optional<Todo> optionalTodo = this.todoService.getTodoById(id);
		if (optionalTodo.isPresent()) {
			Todo todo = optionalTodo.get();
			todo.setTitle(updatedTodo.getTitle());
			todo.setCompleted(updatedTodo.isCompleted());
			return ResponseEntity.ok(this.todoService.updateTodo(todo));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteTodoById(@PathVariable Long id) {
		if (this.todoService.getTodoById(id).isPresent()) {
			this.todoService.deleteTodoById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
