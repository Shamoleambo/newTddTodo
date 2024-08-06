package com.tidz.tddTodo.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class TodoTest {

	@Test
	void testCreateTodo() {
		Todo todo = new Todo(1L, "title", false);
		assertEquals(1L, todo.getId());
		assertEquals("title", todo.getTitle());
		assertFalse(todo.isCompleted());
	}
}
