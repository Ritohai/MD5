package ra.model.service.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import ra.model.entity.Category;
import ra.model.entity.Post;
import ra.model.service.IGenericService;

public interface ICategoryService extends IGenericService<Category,Long> {

}