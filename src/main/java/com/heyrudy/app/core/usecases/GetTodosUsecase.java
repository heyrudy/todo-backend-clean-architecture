package com.heyrudy.app.core.usecases;

import com.heyrudy.app.core.states.Todo;
import com.heyrudy.app.core.abilities.storage.ITodoStore;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public record GetTodosUsecase(ITodoStore store) {

    public List<Todo> execute() {
        return store.getTodos();
    }
}
