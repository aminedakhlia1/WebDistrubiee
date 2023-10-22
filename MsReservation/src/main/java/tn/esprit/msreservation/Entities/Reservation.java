package tn.esprit.msreservation.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation ;
    @Temporal(TemporalType.DATE)
    private Date dateDebut ;
    @Temporal(TemporalType.DATE)
    private Date dateFin ;
    private Statut statut ;
    private Float accompte ;
    private Float caution ;
    private String email ;
    @JsonIgnore
    @OneToOne(mappedBy = "reservation")
    private Vehicule vehicule;
}
