package com.heyrudy.app.core.usecases.validators;

import com.heyrudy.app.core.states.Todo;

public record TodoValidator() {

    public boolean validateTodoItem(final Todo todo) {
        return  todo.getTodoID() != null &&
                todo.getTitle() != null &&
                todo.getTask() != null &&
                todo.getCompleted() != null;
    }
}
