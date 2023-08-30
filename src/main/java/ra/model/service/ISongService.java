package ra.model.service;

import ra.model.dto.SongDtoForm;
import ra.model.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findById(Long id);
    void save(SongDtoForm songdtoform);
    void delete(Long id);
}
