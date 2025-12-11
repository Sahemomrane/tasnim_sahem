package tn.esprit.tpfoyer2.Services;

import tn.esprit.tpfoyer2.Entity.Foyer;
import java.util.*;

public interface IFoyerInterface {
    List<Foyer> retrieveAllFoyers();
    Foyer addFoyer (Foyer f);
    Foyer updateFoyer (Foyer f);
    Optional<Foyer> retrieveFoyer (long idFoyer);
    void removeFoyer (long idFoyer);
}
