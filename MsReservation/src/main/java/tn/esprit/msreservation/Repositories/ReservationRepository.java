package tn.esprit.msreservation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.msreservation.Entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
