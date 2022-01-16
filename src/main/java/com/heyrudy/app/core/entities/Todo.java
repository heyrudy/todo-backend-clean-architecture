package com.heyrudy.app.core.entities;

public record Todo(TodoID todoID, Title title, Task task, Completed completed) {

    public Todo() {
        this(new TodoID(0L), new Title(""), new Task(""), new Completed(false));
    }

    public static Todo initTodo() {
        return new Todo();
    }

    public Todo withId(final TodoID id) {
        return new Todo(id, title, task, completed);
    }

    public Todo withTitle(final Title title) {
        return new Todo(todoID, title, task, completed);
    }

    public Todo withTask(final Task task) {
        return new Todo(todoID, title, task, completed);
    }

    public Todo withCompleted(final Completed completed) {
        return new Todo(todoID, title, task, completed);
    }

    public record TodoID(Long id) {
    }

    public record Title(String title) {
    }

    public record Task(String task) {
    }

    public record Completed(Boolean completed) {
    }
}
