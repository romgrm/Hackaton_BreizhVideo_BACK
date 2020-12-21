package fr.breizhvideo.backend.Controller;

import fr.breizhvideo.backend.Model.Village;
import fr.breizhvideo.backend.Repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class VillageController {

    @Autowired
    private VillageRepository villageRepository;

    // Renvoie liste de tous les villages
    @CrossOrigin
    @GetMapping(value="/Village")
    List<Village> allVillage() {
        return villageRepository.findAll();
    }

    // Renvoie un village via son id
    @CrossOrigin
    @GetMapping(value="/Village/{id}")
    public Optional<Village> villageById(@PathVariable int id){
        return villageRepository.findById(id);
    }

    // Créer un village
    @CrossOrigin
    @PostMapping(value="/Village")
    public ResponseEntity<Void> createVillage(@RequestBody Village village ) {
        Village savedVillage = villageRepository.save(village);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedVillage.getId()).toUri();

        // On return la création/build de notre URI
        return ResponseEntity.created(location).build();
    }

    // Mettre à jour un village déjà existant
    @CrossOrigin
    @PutMapping(value="/Village")
    public void updateVillage(@RequestBody Village village ) {
        villageRepository.save(village);
    }

    // Supprimer un village via son Id
    @CrossOrigin
    @DeleteMapping(value="/Village/{id}")
    public void deleteVillage(@PathVariable int id){
        villageRepository.deleteById(id);
    }
}
