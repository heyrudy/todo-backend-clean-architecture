package com.heyrudy.core.entities;

public final class Todo {
    private Long id;
    private String title;
    private String task;
    private boolean completed;

    public static Todo builder() {
        return new Todo();
    }

    public Long getId() {
        return id;
    }

    public Todo id(final long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Todo title(final String title) {
        this.title = title;
        return this;
    }

    public String getTask() {
        return task;
    }

    public Todo task(final String task) {
        this.task = task;
        return this;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Todo completed(final boolean completed) {
        this.completed = completed;
        return this;
    }

    public Todo build() {
        return this;
    }

    @Override
    public String toString() {
        return "TodoTask{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", task='" + task + '\'' +
                ", completed=" + completed +
                '}';
    }
}
