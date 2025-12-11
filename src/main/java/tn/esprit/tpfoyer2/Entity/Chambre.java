package tn.esprit.tpfoyer2.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    private Long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chambre")
    private Set<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "id_bloc")
    Bloc bloc;
}