package ra.ss5spingboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.ss5spingboot.model.domain.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
  boolean existsByEmail(String email);
  boolean existsByPhoneNumber(String phone);
}
