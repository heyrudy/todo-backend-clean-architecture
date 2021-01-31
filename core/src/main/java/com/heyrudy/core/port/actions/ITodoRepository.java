package com.heyrudy.core.port.actions;

import com.heyrudy.core.entities.Todo;

import java.util.List;
import java.util.Optional;

public interface ITodoRepository {

    Optional<Todo> getTodoById(final long id);

    List<Todo> getTodos();

    Todo saveTodo(final Todo todo);

    Todo updateTodo(final Todo todo);

    void deleteTodoById(final long id);
}
