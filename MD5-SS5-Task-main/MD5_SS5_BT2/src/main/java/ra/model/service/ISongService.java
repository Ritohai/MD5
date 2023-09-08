package ra.model.service;

import ra.model.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findById(Long id);
    void save(Song song);
    void delete(Long id);
}
