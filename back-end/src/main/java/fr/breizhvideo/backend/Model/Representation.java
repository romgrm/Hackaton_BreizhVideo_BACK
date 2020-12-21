package fr.breizhvideo.backend.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
public @Data class Representation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String release_date;

    @ManyToOne @JoinColumn
    private Village village;
}
