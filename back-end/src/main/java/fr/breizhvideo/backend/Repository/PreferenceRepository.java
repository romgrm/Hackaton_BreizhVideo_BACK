package fr.breizhvideo.backend.Repository;

import fr.breizhvideo.backend.Model.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenceRepository extends JpaRepository<Preference, Integer> {
}
