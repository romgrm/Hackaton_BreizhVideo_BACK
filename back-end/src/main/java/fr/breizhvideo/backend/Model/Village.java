package fr.breizhvideo.backend.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public @Data class Village {
    // Id auto-incrémenté
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String postCode;

    /*@OneToMany(mappedBy = "village")
    private List<Representation> representations;*/
}
