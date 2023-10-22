package tn.esprit.msreservation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.msreservation.Entities.Reservation;
import tn.esprit.msreservation.Entities.Weather;
import tn.esprit.msreservation.Services.NotificationService;
import tn.esprit.msreservation.Services.ReservationServiceIMP;
import tn.esprit.msreservation.Services.WeatherService;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private  ReservationServiceIMP reservationService;
    @Autowired
    private NotificationService notificationService ;
    @Autowired
    private WeatherService weatherService;

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.createReservation(reservation);

        // Envoyer un e-mail de confirmation
        notificationService.sendConfirmationEmail(createdReservation);

        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation != null) {
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        Reservation updatedReservation = reservationService.updateReservation(reservation);
        return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/city/{cityName}")
    public ResponseEntity<Weather> getWeatherByCity(@PathVariable String cityName) {
        Weather weather = weatherService.getWeatherByCityName(cityName);
        if (weather != null) {
            return new ResponseEntity<>(weather, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

