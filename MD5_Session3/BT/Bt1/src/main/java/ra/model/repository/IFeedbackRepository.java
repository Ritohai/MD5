package ra.model.repository;




import org.springframework.data.repository.PagingAndSortingRepository;
import ra.model.entity.Feedback;

public interface IFeedbackRepository extends PagingAndSortingRepository<Feedback, Long> {

}