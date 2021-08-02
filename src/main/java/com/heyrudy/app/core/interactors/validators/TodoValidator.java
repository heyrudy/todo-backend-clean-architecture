package com.heyrudy.app.core.interactors.validators;

import com.heyrudy.app.core.entities.Todo;

public final class TodoValidator {

    public boolean validateTodoItem(final Todo todo) {
        return  todo.getId() != null &&
                todo.getTitle() != null &&
                todo.getTask() != null &&
                todo.isCompleted() != null;
    }
}
