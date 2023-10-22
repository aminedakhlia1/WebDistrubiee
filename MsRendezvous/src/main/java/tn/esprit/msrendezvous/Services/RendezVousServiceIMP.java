package tn.esprit.msrendezvous.Services;

import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.msrendezvous.Entities.RendezVous;
import tn.esprit.msrendezvous.Entities.ReservationRDV;
import tn.esprit.msrendezvous.Entities.User;
import tn.esprit.msrendezvous.Repositories.RendezVousRepo;
import tn.esprit.msrendezvous.Repositories.ReservationRDVRepo;
import tn.esprit.msrendezvous.Repositories.UserRepo;

import java.util.Date;
import java.util.List;

@Service
public class RendezVousServiceIMP implements IRendezVousService{
    @Autowired
    private UserRepo userRepo ;
    @Autowired
    public RendezVousRepo rendezVousRepository;
    @Autowired
    public ReservationRDVRepo reservationRDVRepo ;

    @Override
    public List<RendezVous> getAllRendezVous() {
        return rendezVousRepository.findAll();
    }

    @Override
    public RendezVous getRendezVousById(Long id) {
        return rendezVousRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("RendezVous not found with id " + id));
    }

    @Override
    public RendezVous createRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }
    @Override
    public RendezVous updateRendezVous(Long id, RendezVous updatedRendezVous) {
        RendezVous existingRendezVous = rendezVousRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("RendezVous not found with id " + id));

        // Update the fields you want to change
        existingRendezVous.setTitre(updatedRendezVous.getTitre());
        existingRendezVous.setDescription(updatedRendezVous.getDescription());
        existingRendezVous.setDateRdv(updatedRendezVous.getDateRdv());
        existingRendezVous.setHeureRDV(updatedRendezVous.getHeureRDV());
        existingRendezVous.setLocalisationRDV(updatedRendezVous.getLocalisationRDV());

        return rendezVousRepository.save(existingRendezVous);
    }
    @Override
    public void deleteRendezVous(Long id) {
        if (!rendezVousRepository.existsById(id)) {
            throw new NotFoundException("RendezVous not found with id " + id);
        }
        rendezVousRepository.deleteById(id);
    }
    @Override
    public ReservationRDV createReservationrdv(Long userId, Long rendezVousId, Date reservationDate) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id " + userId));
        RendezVous rendezVous = rendezVousRepository.findById(rendezVousId)
                .orElseThrow(() -> new NotFoundException("RendezVous not found with id " + rendezVousId));
        // Add validation to check for double bookings and other business rules

        ReservationRDV reservation = new ReservationRDV();
        reservation.setUser(user);
        reservation.setRendezVous(rendezVous);
        reservation.setReservationDate(reservationDate);

        return reservationRDVRepo.save(reservation);
    }

}
