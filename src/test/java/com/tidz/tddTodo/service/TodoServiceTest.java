package com.tidz.tddTodo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tidz.tddTodo.entity.Todo;
import com.tidz.tddTodo.repository.TodoRepository;

public class TodoServiceTest {

	@Mock
	private TodoRepository todoRepository;

	@InjectMocks
	private TodoService todoService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddTodo() {
		Todo todo = new Todo();
		todo.setTitle("title");

		when(this.todoRepository.save(todo)).thenReturn(todo);

		Todo createdTodo = this.todoService.addTodo(todo);

		assertEquals("title", createdTodo.getTitle());
		verify(this.todoRepository, times(1)).save(todo);
	}

	@Test
	void testGetTodo() {
		Todo todo = new Todo();
		todo.setId(1L);
		todo.setTitle("title");

		when(this.todoRepository.findById(1L)).thenReturn(Optional.of(todo));

		Optional<Todo> optionalTodo = this.todoService.getTodoById(1L);

		assertTrue(optionalTodo.isPresent());
		assertEquals("title", optionalTodo.get().getTitle());
	}

	@Test
	void testGetAllTodos() {
		Todo todo = new Todo(1L, "title", false);

		when(this.todoRepository.findAll()).thenReturn(List.of(todo));

		List<Todo> todos = this.todoService.getAllTodos();

		assertEquals(1, todos.size());
		assertEquals(todo, todos.get(0));
	}

}
