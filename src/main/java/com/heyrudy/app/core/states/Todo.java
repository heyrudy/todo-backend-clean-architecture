package com.heyrudy.app.core.states;

public final class Todo {

    private Long todoID;
    private String title;
    private String task;
    private Boolean completed;

    public Todo() {
    }

    public Todo(Long todoID, String title, String task, Boolean completed) {
        this.todoID = todoID;
        this.title = title;
        this.task = task;
        this.completed = completed;
    }

    public static Todo initTodo() {
        return new Todo();
    }

    public Todo withId(Long id) {
        return new Todo(id, title, task, completed);
    }

    public Todo withTitle(String title) {
        return new Todo(todoID, title, task, completed);
    }

    public Todo withTask(String task) {
        return new Todo(todoID, title, task, completed);
    }

    public Todo withCompleted(Boolean completed) {
        return new Todo(todoID, title, task, completed);
    }

    public Long getTodoID() {
        return todoID;
    }

    public void setTodoID(Long todoID) {
        this.todoID = todoID;
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
