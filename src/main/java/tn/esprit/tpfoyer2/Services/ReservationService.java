package tn.esprit.tpfoyer2.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer2.Entity.Reservation;
import tn.esprit.tpfoyer2.Repository.ReservationRepository;
import java.util.*;
@Service
@AllArgsConstructor
public class ReservationService implements IReservationInterface {
    private final ReservationRepository rr;
    @Override
    public List<Reservation> retrieveAllReservation() {
        return rr.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return rr.save(res);
    }

    @Override
    public Optional<Reservation> retrieveReservation(String idReservation) {
        return rr.findById(idReservation);
    }
}
