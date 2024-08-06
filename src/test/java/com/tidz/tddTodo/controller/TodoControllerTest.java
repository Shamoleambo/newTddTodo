package com.tidz.tddTodo.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.tidz.tddTodo.TodoController;
import com.tidz.tddTodo.entity.Todo;
import com.tidz.tddTodo.service.TodoService;

@WebMvcTest(TodoController.class)
public class TodoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TodoService todoService;

	@Test
	void testGetAllTodos() throws Exception {
		Todo todo = new Todo();
		todo.setTitle("title");

		when(this.todoService.getAllTodos()).thenReturn(Collections.singletonList(todo));

		this.mockMvc.perform(get("/todos")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].title", is("title")));
	}
}
