package service;

import java.util.List;

public interface IService<E> {
    E findByID(int id);

    void add(E e);

    void edit(int id, E e);

    void delete(int id);

    List<E> findAll();
}
