package com.heyrudy.app.core.interactors.validators;

import com.heyrudy.app.core.entities.Todo;

public final class TodoValidator {

    public boolean validateTodoItem(final Todo todo) {
        return todo.id() != null
                && todo.task() != null
                && todo.title() != null
                && todo.completed() != null;
    }
}
