package tn.esprit.msrendezvous.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.msrendezvous.Entities.RendezVous;
import tn.esprit.msrendezvous.Entities.ReservationRDV;
import tn.esprit.msrendezvous.Services.IRendezVousService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rendezvous")
public class RendezVousController {
    @Autowired
    private IRendezVousService rendezVousService;


    @GetMapping
    public List<RendezVous> getAllRendezVous() {
        return rendezVousService.getAllRendezVous();
    }

    @GetMapping("/{id}")
    public RendezVous getRendezVousById(@PathVariable Long id) {
        return rendezVousService.getRendezVousById(id);
    }

    @PostMapping
    public RendezVous createRendezVous(@RequestBody RendezVous rendezVous) {
        return rendezVousService.createRendezVous(rendezVous);
    }

    @PutMapping("/{id}")
    public RendezVous updateRendezVous(@PathVariable Long id, @RequestBody RendezVous updatedRendezVous) {
        return rendezVousService.updateRendezVous(id, updatedRendezVous);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRendezVous(@PathVariable Long id) {
        rendezVousService.deleteRendezVous(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("createreservRDV")
    public ReservationRDV createReservation(
            @RequestParam Long userId,
            @RequestParam Long rendezVousId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date reservationDate){
           return rendezVousService.createReservationrdv(userId,rendezVousId,reservationDate);
    }
}

