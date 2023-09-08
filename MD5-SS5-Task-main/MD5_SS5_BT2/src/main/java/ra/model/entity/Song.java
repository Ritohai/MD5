package ra.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max =800)
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$")
    private String name;
    @NotBlank
    @Size(max =300)
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$")
    private String singer;
    @NotBlank
    @Size(max =1000)
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$")
    private String category;

    public Song() {
    }

    public Song(Long id, String name, String singer, String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
