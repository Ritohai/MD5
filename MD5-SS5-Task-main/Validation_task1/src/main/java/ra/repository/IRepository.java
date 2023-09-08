package ra.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.model.User;

@Repository
public interface IRepository extends PagingAndSortingRepository<User,Long> {
}
