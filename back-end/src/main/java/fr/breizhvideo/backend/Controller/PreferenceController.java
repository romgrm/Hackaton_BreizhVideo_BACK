package fr.breizhvideo.backend.Controller;

import fr.breizhvideo.backend.Model.Preference;
import fr.breizhvideo.backend.Repository.PreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.Entity;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class PreferenceController {

    @Autowired
    private PreferenceRepository preferenceRepository;

    // Renvoie liste de tous les votes
    @CrossOrigin
    @GetMapping(value="/Preference")
    List<Preference> allPreference() {
        return preferenceRepository.findAll();
    }

    // Renvoie un vote via son id
    @CrossOrigin
    @GetMapping(value="/Preference/{id}")
    public Optional<Preference> preferenceById(@PathVariable int id){
        return preferenceRepository.findById(id);
    }

    // Créer un vote
    @CrossOrigin
    @PostMapping(value="/Preference")
    public ResponseEntity<Void> createPreference(@RequestBody Preference preference ) {
        Preference savedPreference = preferenceRepository.save(preference);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPreference.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
