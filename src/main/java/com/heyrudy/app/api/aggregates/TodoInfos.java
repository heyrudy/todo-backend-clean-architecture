package com.heyrudy.app.api.aggregates;

import com.heyrudy.app.core.entities.Todo;

public final class TodoInfos {

    private String title;
    private String task;
    private Boolean completed;

    public TodoInfos() {
    }

    public TodoInfos(String title, String task, Boolean completed) {
        this.title = title;
        this.task = task;
        this.completed = completed;
    }

    public static TodoInfos initTodoInfos() {
        return new TodoInfos();
    }

    public TodoInfos withTitle(String title) {
        return new TodoInfos(title, task, completed);
    }

    public TodoInfos withTask(String task) {
        return new TodoInfos(title, task, completed);
    }

    public TodoInfos withCompleted(Boolean completed) {
        return new TodoInfos(title, task, completed);
    }

    public Todo toTodo() {
        return Todo.initTodo().withTitle(title).withTask(task).withCompleted(completed);
    }

    public static TodoInfos toTodoInfos(final Todo todo) {
        return TodoInfos.initTodoInfos().withTitle(todo.getTitle()).withTask(todo.getTask()).withCompleted(todo.getCompleted());
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
