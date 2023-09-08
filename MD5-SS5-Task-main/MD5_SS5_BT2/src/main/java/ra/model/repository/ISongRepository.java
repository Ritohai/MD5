package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.Song;
@Repository
public interface ISongRepository extends JpaRepository<Song,Long> {
}
