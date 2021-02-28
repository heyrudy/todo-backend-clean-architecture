package com.heyrudy.app.core.interactors;

import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.port.actions.ITodoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class GetTodosUsecase {

    private final ITodoRepository repository;

    public GetTodosUsecase(ITodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> execute() {
        return repository.getTodos();
    }
}
