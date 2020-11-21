package com.heyrudy.core.interactors;

import com.heyrudy.core.entities.Todo;
import com.heyrudy.core.port.actions.ITodoRepository;

import java.util.List;

public final class GetTodosUsecase {

    private final ITodoRepository repository;

    public GetTodosUsecase(ITodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> execute() {
        return repository.getTodos();
    }
}
