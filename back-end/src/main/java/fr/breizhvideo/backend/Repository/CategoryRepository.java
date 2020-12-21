package fr.breizhvideo.backend.Repository;

import fr.breizhvideo.backend.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
