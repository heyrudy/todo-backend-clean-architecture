package com.heyrudy.app.core.interactors;

import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.abilities.storage.ITodoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public record GetTodosUsecase(ITodoRepository repository) {

    public List<Todo> execute() {
        return repository.getTodos();
    }
}
