package tn.esprit.msreservation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.msreservation.Entities.Vehicule;

public interface VehiculeRepository  extends JpaRepository<Vehicule, Long> {
}
