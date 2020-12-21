package fr.breizhvideo.backend.Controller;

import fr.breizhvideo.backend.Model.Representation;
import fr.breizhvideo.backend.Repository.RepresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class RepresentationController {

    @Autowired
    private RepresentationRepository representationRepository;

    // Renvoie liste de tous les representations
    @CrossOrigin
    @GetMapping(value="/Representation")
    List<Representation> allRepresentations() {
        return representationRepository.findAll();
    }

    // Renvoie une rep via son id
    @CrossOrigin
    @GetMapping(value="/Representation/{id}")
    public Optional<Representation> representationById(@PathVariable int id){
        return representationRepository.findById(id);
    }

    // Créer une rep
    @CrossOrigin
    @PostMapping(value="/Representation")
    public ResponseEntity<Void> createRepresentation(@RequestBody Representation representation ) {
        Representation savedRepresentation = representationRepository.save(representation);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRepresentation.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
