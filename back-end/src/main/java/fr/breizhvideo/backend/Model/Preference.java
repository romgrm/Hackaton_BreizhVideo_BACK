package fr.breizhvideo.backend.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
public @Data class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int vote;

    @ManyToOne @JoinColumn
    private Representation representations;
    @ManyToOne @JoinColumn
    private Film films;
}
