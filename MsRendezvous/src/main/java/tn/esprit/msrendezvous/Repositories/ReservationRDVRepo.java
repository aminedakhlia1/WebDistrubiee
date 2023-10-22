package tn.esprit.msrendezvous.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.msrendezvous.Entities.ReservationRDV;

public interface ReservationRDVRepo extends JpaRepository<ReservationRDV,Long> {
}
