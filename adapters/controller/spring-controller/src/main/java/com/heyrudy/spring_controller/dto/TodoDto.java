package com.heyrudy.spring_controller.dto;

import com.heyrudy.core.entities.Todo;

public final class TodoDto {
    private Long id;
    private String title;
    private String task;
    private boolean completed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
                .id(this.id)
                .title(this.title)
                .task(this.task)
                .completed(this.completed)
                .build();
    }

    public static TodoDto toTodoDto(final Todo todo) {
        TodoDto todoDtoWeb = new TodoDto();
        todoDtoWeb.setId(todo.getId());
        todoDtoWeb.setTitle(todo.getTitle());
        todoDtoWeb.setTask(todo.getTask());
        todoDtoWeb.setCompleted(todo.isCompleted());
        return todoDtoWeb;
    }
}
