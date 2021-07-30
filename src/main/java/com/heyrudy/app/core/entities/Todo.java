package com.heyrudy.app.core.entities;

public record Todo(Long id, String title, String task, Boolean completed) {

    public Todo() {
        this(0L, "", "", false);
    }

    public Todo withID(final Long id) {
        return new Todo(id, title, task, completed);
    }

    public Todo withTitle(final String title) {
        return new Todo(id, title, task, completed);
    }

    public Todo withTask(final String task) {
        return new Todo(id, title, task, completed);
    }

    public Todo withCompleted(final boolean completed) {
        return new Todo(id, title, task, completed);
    }

    public static Todo builder() {
        return new Todo();
    }

    public Todo build() {
        return this;
    }
}
