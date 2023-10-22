package tn.esprit.msreservation.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule ;
    private String matricule ;
    private String image ;
    private Long nbSiege ;
    private Float prix ;
    @OneToOne()
    private Reservation reservation ;
    @ManyToOne()
    private User uservehicule ;

}
