package fr.breizhvideo.backend.Repository;

import fr.breizhvideo.backend.Model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Integer> {
}
