package ra.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import ra.model.dto.SongDtoForm;
import ra.model.entity.Song;
import ra.model.repository.ISongRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;
    @Override
    public List<Song> findAll() {

        return songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {

        return songRepository.findById(id);
    }

    @Override
    public void save(SongDtoForm songDtoForm) {
        String uploadPath = "C:\\Users\\Admin\\Desktop\\md5-btss1-main\\src\\main\\webapp\\WEB-INF\\upload\\";
        // xử lí chuyển đổi
        // upload file
        String filename = null;
        if(!(songDtoForm.getUrl().isEmpty())){
            filename = songDtoForm.getUrl().getOriginalFilename();
            try {
                FileCopyUtils.copy(songDtoForm.getUrl().getBytes(),new File(uploadPath+filename));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // chuyển từ dto thành entity
        Song song = new Song(songDtoForm.getId(),
                songDtoForm.getName(),songDtoForm.getSinger(),
                songDtoForm.getGenre(), filename);
        songRepository.save(song);
    }

    @Override
    public void delete(Long id) {
        songRepository.delete(id);
    }
}
