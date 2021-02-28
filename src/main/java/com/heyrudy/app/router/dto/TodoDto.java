package com.heyrudy.app.router.dto;

import com.heyrudy.app.core.entities.Todo;

public final class TodoDto {

    private String title;
    private String task;
    private boolean completed;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Todo toTodo() {
        return Todo.builder()
                .title(this.title)
                .task(this.task)
                .completed(this.completed)
                .build();
    }

    public static TodoDto toTodoDto(final Todo todo) {
        TodoDto todoDtoWeb = new TodoDto();
        todoDtoWeb.setTitle(todo.getTitle());
        todoDtoWeb.setTask(todo.getTask());
        todoDtoWeb.setCompleted(todo.isCompleted());
        return todoDtoWeb;
    }
}
