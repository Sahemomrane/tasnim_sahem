package tn.esprit.tpfoyer2.Services;

import tn.esprit.tpfoyer2.Entity.Reservation;
import java.util.*;

public interface IReservationInterface {
    List<Reservation> retrieveAllReservation();
    Reservation updateReservation (Reservation  res);
    Optional<Reservation> retrieveReservation (String idReservation);
}