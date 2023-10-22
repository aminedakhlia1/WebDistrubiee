package tn.esprit.msreservation.Services;

import tn.esprit.msreservation.Entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation createReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    void deleteReservation(Long id);
    Reservation getReservationById(Long id);
    List<Reservation> getAllReservations();
}
