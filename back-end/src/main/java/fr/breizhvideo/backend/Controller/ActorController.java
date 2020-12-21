package fr.breizhvideo.backend.Controller;

import fr.breizhvideo.backend.Model.Actor;
import fr.breizhvideo.backend.Repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    // Renvoie liste de tous les actor
    @CrossOrigin
    @GetMapping(value="/Actor")
    List<Actor> allActor() {
        return actorRepository.findAll();
    }

    // Renvoie un actor via son id
    @CrossOrigin
    @GetMapping(value="/Actor/{id}")
    public Optional<Actor> actorById(@PathVariable int id){
        return actorRepository.findById(id);
    }

    // Créer un Actor
    @CrossOrigin
    @PostMapping(value="/Actor")
    public ResponseEntity<Void> createActor(@RequestBody Actor actor ) {
        Actor savedActor = actorRepository.save(actor);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedActor.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    // Mettre à jour un Actor déjà existant
    @CrossOrigin
    @PutMapping(value="/Actor")
    public void updateActor(@RequestBody Actor actor ) {
        actorRepository.save(actor);
    }

    // Supprimer un Actor via son Id
    @CrossOrigin
    @DeleteMapping(value="/Actor/{id}")
    public void deleteActor(@PathVariable int id){
        actorRepository.deleteById(id);
    }
}
