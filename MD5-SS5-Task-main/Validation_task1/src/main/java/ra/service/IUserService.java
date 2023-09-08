package ra.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import ra.model.User;

public interface IUserService {
    Page<User> findAll(Pageable pageable);
    void save(User product);
    Page<User> findAllByNameContaining(String name, Pageable pageable);
    Page<User> findByFirstName(@Param("name") String name, Pageable pageable);
}
