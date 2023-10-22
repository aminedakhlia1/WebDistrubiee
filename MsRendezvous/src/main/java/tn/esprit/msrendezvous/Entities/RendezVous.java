package tn.esprit.msrendezvous.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
public class RendezVous implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRendezVous ;
    private String titre ;
    private String description ;
    @Temporal(TemporalType.DATE)
    private Date dateRdv ;
    @Temporal(TemporalType.TIME)
    private Date heureRDV ;
    private String localisationRDV ;
    @ManyToOne
    private User user ;
}
