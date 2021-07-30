package com.heyrudy.app.core.entities;

public record Todo(long id, String title, String task, boolean completed) {

    public Todo() {
        this(0L, "", "", false);
    }

    public Todo setID(final long id) {
        return new Todo(id, title, task, completed);
    }

    public Todo setTitle(final String title) {
        return new Todo(id, title, task, completed);
    }

    public Todo setTask(final String task) {
        return new Todo(id, title, task, completed);
    }

    public Todo setCompleted(final boolean completed) {
        return new Todo(id, title, task, completed);
    }

    public static Todo builder() {
        return new Todo();
    }

    public Todo id(final long id) {
        return this.setID(id);
    }

    public Todo title(final String title) {
        return this.setTitle(title);
    }

    public Todo task(final String task) {
        return this.setTask(task);
    }

    public Todo completed(final boolean completed) {
        return this.setCompleted(completed);
    }

    public Todo build() {
        return this;
    }
}
