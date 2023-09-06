package ra.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.Category;
import ra.model.entity.Post;

@Repository
public interface ICategoryRepository  extends PagingAndSortingRepository<Category, Long> {

}