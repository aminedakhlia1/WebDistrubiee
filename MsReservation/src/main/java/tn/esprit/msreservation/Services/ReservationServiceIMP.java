package tn.esprit.msreservation.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.msreservation.Entities.Reservation;
import tn.esprit.msreservation.Repositories.ReservationRepository;

import java.util.List;

@Service
public class ReservationServiceIMP implements IReservationService{
    @Autowired
    private  ReservationRepository reservationRepository;

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}

