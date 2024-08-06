package com.tidz.tddTodo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

}
