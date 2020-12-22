package fr.breizhvideo.backend.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    // relation avec Category table dans Bdd
    @ManyToMany
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonManagedReference
    List<Category> category;

    // relation avec Actor table dans Bdd
    @ManyToMany
    @JoinTable(name = "film_actor",
                joinColumns = @JoinColumn(name = "film_id"),
                inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    @JsonManagedReference
    List<Actor> actors;
}
