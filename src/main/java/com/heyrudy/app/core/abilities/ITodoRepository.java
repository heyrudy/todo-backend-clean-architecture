package com.heyrudy.app.core.abilities;

import com.heyrudy.app.core.entities.Todo;

import java.util.List;
import java.util.Optional;

public interface ITodoRepository {

    Optional<Todo> getTodoById(final Long id);

    List<Todo> getTodos();

    void saveTodo(final Todo todo);

    void updateTodo(final Todo todo);

    void deleteTodoById(final Long id);
}
