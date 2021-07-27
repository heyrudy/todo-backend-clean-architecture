package com.heyrudy.app.router.dto;

import com.heyrudy.app.core.entities.Todo;

public final record TodoDto(String title, String task, boolean completed) {

    public Todo toTodo() {
        return Todo.builder()
                .title(title)
                .task(task)
                .completed(completed)
                .build();
    }

    public static TodoDto toTodoDto(final Todo todo) {
        return new TodoDto(todo.title(), todo.task(), todo.completed());
    }
}
