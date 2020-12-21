package fr.breizhvideo.backend.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public @Data class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private int releaseYear;
    private int length;

    @ManyToMany
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<Category> category;

    @ManyToMany
    @JoinTable(name = "film_actor",
                joinColumns = @JoinColumn(name = "film_id"),
                inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    List<Actor> actors;
}
