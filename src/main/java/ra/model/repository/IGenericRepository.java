package ra.model.repository;

import java.util.List;

public interface IGenericRepository<T, E> {
    List<T> findAll();

    T findByID(E id);

    void save(T s);

    void delete(E id);
}
