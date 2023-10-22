package tn.esprit.msrendezvous.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.msrendezvous.Entities.RendezVous;

public interface RendezVousRepo extends JpaRepository<RendezVous,Long> {
}
