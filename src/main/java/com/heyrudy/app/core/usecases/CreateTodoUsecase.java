package com.heyrudy.app.core.usecases;

import com.heyrudy.app.core.states.Todo;
import com.heyrudy.app.core.abilities.storage.ITodoStore;
import org.springframework.stereotype.Component;

@Component
public record CreateTodoUsecase(ITodoStore store) {

    public void execute(final Todo todo) {
        store.saveTodo(todo);
    }
}
