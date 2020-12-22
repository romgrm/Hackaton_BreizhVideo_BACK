package fr.breizhvideo.backend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    // relation avec Film table dans Bdd
    @ManyToMany(mappedBy = "actors")
    @JsonBackReference
    private List<Film> filmList;

}
