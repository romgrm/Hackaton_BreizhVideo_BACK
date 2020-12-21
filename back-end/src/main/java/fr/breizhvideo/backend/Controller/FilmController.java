package fr.breizhvideo.backend.Controller;

import fr.breizhvideo.backend.Model.Film;
import fr.breizhvideo.backend.Repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

    // Renvoie liste de tous les films
    @CrossOrigin
    @GetMapping(value="/Film")
    List<Film> allFilm() {
        return filmRepository.findAll();
    }

    // Renvoie un film via son id
    @CrossOrigin
    @GetMapping(value="/Film/{id}")
    public Optional<Film> filmById(@PathVariable int id){
        return filmRepository.findById(id);
    }

    // Créer un film
    @CrossOrigin
    @PostMapping(value="/Film")
    public ResponseEntity<Void> createActor(@RequestBody Film film ) {
        Film savedFilm = filmRepository.save(film);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedFilm.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    // Mettre à jour un film déjà existant
    @CrossOrigin
    @PutMapping(value="/Film")
    public void updateFilm(@RequestBody Film film ) {
        filmRepository.save(film);
    }

    // Supprimer un film via son Id
    @CrossOrigin
    @DeleteMapping(value="/Film/{id}")
    public void deleteFilm(@PathVariable int id){
        filmRepository.deleteById(id);
    }
}

