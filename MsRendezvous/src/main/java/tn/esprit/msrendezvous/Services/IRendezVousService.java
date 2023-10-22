package tn.esprit.msrendezvous.Services;

import tn.esprit.msrendezvous.Entities.RendezVous;
import tn.esprit.msrendezvous.Entities.ReservationRDV;

import java.util.Date;
import java.util.List;

public interface IRendezVousService {
        List<RendezVous> getAllRendezVous();
        RendezVous getRendezVousById(Long id);
        RendezVous createRendezVous(RendezVous rendezVous);
        RendezVous updateRendezVous(Long id, RendezVous rendezVous);
        void deleteRendezVous(Long id);

       ReservationRDV createReservationrdv(Long userId, Long rendezVousId, Date reservationDate);
}

