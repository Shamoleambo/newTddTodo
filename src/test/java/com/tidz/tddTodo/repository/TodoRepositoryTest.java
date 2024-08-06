package com.tidz.tddTodo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tidz.tddTodo.entity.Todo;

@DataJpaTest
public class TodoRepositoryTest {

	@Autowired
	private TodoRepository todoRepository;

	@Test
	void testSaveTodo() {
		Todo todo = new Todo();
		todo.setTitle("title");
		todo.setCompleted(false);

		Todo savedTodo = this.todoRepository.save(todo);

		assertNotNull(savedTodo.getId());
		assertEquals("title", savedTodo.getTitle());
		assertFalse(savedTodo.isCompleted());
	}
}
