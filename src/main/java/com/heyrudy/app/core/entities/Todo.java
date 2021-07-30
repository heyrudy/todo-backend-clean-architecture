package com.heyrudy.app.core.entities;

public final class Todo {

    private Long id;
    private String title;
    private String task;
    private Boolean completed;

    public static Todo builder() {
        return new Todo();
    }

    public Long getId() {
        return id;
    }

    public Todo withId(final Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Todo withTitle(final String title) {
        this.title = title;
        return this;
    }

    public String getTask() {
        return task;
    }

    public Todo withTask(final String task) {
        this.task = task;
        return this;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public Todo withCompleted(final Boolean completed) {
        this.completed = completed;
        return this;
    }

    public Todo build() {
        return this;
    }
}
