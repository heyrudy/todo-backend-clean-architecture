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

    @Override
    public Optional<Todo> getTodoById(final long id) {
        return Optional.ofNullable(inMemoryDb.get(id));
    }

    @Override
    public List<Todo> getTodos() {
        return new ArrayList<>(inMemoryDb.values());
    }

    @Override
    public Todo saveTodo(Todo todo) {
        inMemoryDb.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public Todo updateTodo(Todo todo) {
        inMemoryDb.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public void deleteTodoById(final long id) {
        inMemoryDb.remove(id);
    }
}
