package com.heyrudy.storage.spring;

import com.heyrudy.core.entities.Todo;
import com.heyrudy.core.port.actions.ITodoRepository;
import com.heyrudy.storage.spring.entities.TodoEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.heyrudy.storage.spring.entities.TodoEntity.toTodoEntity;


public final class SpringPersistentTodoRepositoryImpl implements ITodoRepository {

    private final EntityManagerFactory emf;

    public SpringPersistentTodoRepositoryImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Optional<Todo> getTodoById(final long id) {
        EntityManager em = emf.createEntityManager();
        TodoEntity todoEntity = em.find(TodoEntity.class, id);
        em.close();
        return Optional.of(todoEntity.toTodo());
    }

    public List<Todo> getTodos() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TodoEntity> cq = cb.createQuery(TodoEntity.class);
        Root<TodoEntity> rootEntry = cq.from(TodoEntity.class);
        CriteriaQuery<TodoEntity> all = cq.select(rootEntry);
        TypedQuery<TodoEntity> allQuery = em.createQuery(all);
        em.close();
        return allQuery.getResultList()
                .stream()
                .map(TodoEntity::toTodo)
                .collect(Collectors.toList());
    }

    public com.heyrudy.core.entities.Todo saveTodo(final Todo todo) {
        TodoEntity todoEntity = toTodoEntity(todo);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(todoEntity);
        em.getTransaction().commit();
        em.close();
        return todoEntity.toTodo();
    }

    public Todo updateTodo(final Todo todo) {
        TodoEntity todoEntity = toTodoEntity(todo);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(todoEntity);
        em.getTransaction().commit();
        em.close();
        return todoEntity.toTodo();
    }

    public void deleteTodo(final long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TodoEntity todoEntity = em.find(TodoEntity.class, id);
        em.remove(todoEntity);
        em.getTransaction().commit();
        em.close();
    }

}
