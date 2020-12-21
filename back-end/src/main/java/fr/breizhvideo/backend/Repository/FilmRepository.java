package fr.breizhvideo.backend.Repository;

import fr.breizhvideo.backend.Model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
