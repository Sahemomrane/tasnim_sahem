package tn.esprit.tpfoyer2.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    private String idReservation;
    private Date anneeUniversitaire;
    private boolean estValide;

    @ManyToMany
    @JoinTable(
        name = "reservation_etudiant",
        joinColumns = @JoinColumn(name = "id_reservation"),
        inverseJoinColumns = @JoinColumn(name = "id_etudiant")
    )
    private Set<Etudiant> etudiants;
    
    @ManyToOne
    @JoinColumn(name = "id_chambre")
    private Chambre chambre;
}