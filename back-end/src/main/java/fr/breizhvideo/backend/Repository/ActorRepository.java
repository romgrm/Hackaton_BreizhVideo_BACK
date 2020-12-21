package fr.breizhvideo.backend.Repository;

import fr.breizhvideo.backend.Model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
