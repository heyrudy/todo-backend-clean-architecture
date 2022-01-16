package com.heyrudy.app.aggregates;

import com.heyrudy.app.core.entities.Todo;
import com.heyrudy.app.core.entities.Todo.Completed;
import com.heyrudy.app.core.entities.Todo.Task;
import com.heyrudy.app.core.entities.Todo.Title;

public record TodoInfos(Title title, Task task, Completed completed) {

    public TodoInfos() {
        this(new Title(""), new Task(""), new Completed(false));
    }

    public static TodoInfos initTodoInfos() {
        return new TodoInfos();
    }

    public TodoInfos withTitle(Title title) {
        return new TodoInfos(title, task, completed);
    }

    public TodoInfos withTask(Task task) {
        return new TodoInfos(title, task, completed);
    }

    public TodoInfos withCompleted(Completed completed) {
        return new TodoInfos(title, task, completed);
    }

    public Todo toTodo() {
        return Todo.initTodo()
                .withTitle(title)
                .withTask(task)
                .withCompleted(completed);
    }

    public static TodoInfos toTodoInfos(final Todo todo) {
        return TodoInfos.initTodoInfos()
                .withTitle(todo.title())
                .withTask(todo.task())
                .withCompleted(todo.completed());
    }
}
