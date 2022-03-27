package com.heyrudy.app.core.abilities.storage;

import com.heyrudy.app.core.states.Todo;

import java.util.List;
import java.util.Optional;

public interface ITodoStore {

    Optional<Todo> getTodoById(final Long id);

    List<Todo> getTodos();

    void saveTodo(final Todo todo);

    void updateTodo(final Todo todo);

    void deleteTodoById(final Long id);
}
