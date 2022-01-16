package com.heyrudy.app.adapters.storage.in_memory;

import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.port.actions.ITodoRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class InMemoryTodoRepositoryImpl implements ITodoRepository {

    private final Map<Long, Todo> inMemoryDb = new HashMap<>();

    public Optional<Todo> getTodoById(final Long id) {
        return Optional.ofNullable(inMemoryDb.get(id));
    }

    public List<Todo> getTodos() {
        return new ArrayList<>(inMemoryDb.values());
    }

    public void saveTodo(final Todo todo) {
        inMemoryDb.put(todo.getTodoID().id(), todo);
    }

    public void updateTodo(final Todo todo) {
        this.saveTodo(todo);
    }

    public void deleteTodoById(final Long id) {
        inMemoryDb.remove(id);
    }
}
