package com.heyrudy.storage.spring.entities;

import com.heyrudy.core.entities.Todo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import static com.heyrudy.core.entities.Todo.builder;

@Entity
@Table(name = "TODOS")
public class TodoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String task;
    private boolean completed;

    public TodoEntity() {
    }

    public TodoEntity(long id, String title, String task, boolean completed) {
        this.id = id;
        this.title = title;
        this.task = task;
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return builder()
                .id(this.id)
                .title(this.title)
                .task(this.task)
                .completed(this.completed)
                .build();
    }

    public static TodoEntity toTodoEntity(final Todo todo) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setId(todo.getId());
        todoEntity.setTitle(todo.getTitle());
        todoEntity.setTask(todo.getTask());
        todoEntity.setCompleted(todo.isCompleted());
        return todoEntity;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", task='" + task + '\'' +
                ", completed=" + completed +
                '}';
    }

}
