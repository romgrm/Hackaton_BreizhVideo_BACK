package fr.breizhvideo.backend.Controller;

import fr.breizhvideo.backend.Model.Category;
import fr.breizhvideo.backend.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    // Renvoie liste de toutes les categories
    @CrossOrigin
    @GetMapping(value="/Category")
    List<Category> allCategory() {
        return categoryRepository.findAll();
    }

    // Renvoie une cat via son id
    @CrossOrigin
    @GetMapping(value="/Category/{id}")
    public Optional<Category> categoryById(@PathVariable int id){
        return categoryRepository.findById(id);
    }

    // Créer une category
    @CrossOrigin
    @PostMapping(value="/Category")
    public ResponseEntity<Void> createActor(@RequestBody Category category ) {
        Category savedCategory = categoryRepository.save(category);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCategory.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
