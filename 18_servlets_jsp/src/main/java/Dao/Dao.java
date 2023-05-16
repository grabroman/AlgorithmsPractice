package Dao;

import java.util.List;

public interface Dao<E> {
    void create(E entity);

    void update(E entity);

    void remove(E entity);

    List<E> findAll();

    E findByID(Long id);


}
