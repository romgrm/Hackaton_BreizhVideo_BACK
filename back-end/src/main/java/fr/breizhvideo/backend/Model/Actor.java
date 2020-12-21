package fr.breizhvideo.backend.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public @Data class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "actors")
    private List<Film> filmList;

}
