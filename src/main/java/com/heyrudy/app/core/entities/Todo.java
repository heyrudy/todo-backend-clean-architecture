package com.heyrudy.app.core.entities;

public final class Todo {

    private TodoID id;
    private Title title;
    private Task task;
    private Completed completed;

    public static Todo builder() {
        return new Todo();
    }

    public TodoID getTodoID() {
        return id;
    }

    public Todo withId(final TodoID id) {
        this.id = id;
        return this;
    }

    public Title getTitle() {
        return title;
    }

    public Todo withTitle(final Title title) {
        this.title = title;
        return this;
    }

    public Task getTask() {
        return task;
    }

    public Todo withTask(final Task task) {
        this.task = task;
        return this;
    }

    public Completed isCompleted() {
        return completed;
    }

    public Todo withCompleted(final Completed completed) {
        this.completed = completed;
        return this;
    }

    public Todo build() {
        return this;
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
