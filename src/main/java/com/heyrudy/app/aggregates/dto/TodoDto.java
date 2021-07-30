package com.heyrudy.app.aggregates.dto;

import com.heyrudy.app.core.entities.Todo;

public final record TodoDto(String title, String task, boolean completed) {

    public Todo toTodo() {
        return Todo.builder()
                .withTitle(title)
                .withTask(task)
                .withCompleted(completed)
                .build();
    }

    public static TodoDto toTodoDto(final Todo todo) {
        return new TodoDto(todo.title(), todo.task(), todo.completed());
    }
}
