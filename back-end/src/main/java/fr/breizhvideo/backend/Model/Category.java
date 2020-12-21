package fr.breizhvideo.backend.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public @Data class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "category")
    private List<Film> filmList;
}
