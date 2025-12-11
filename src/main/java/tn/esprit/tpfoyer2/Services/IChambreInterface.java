package tn.esprit.tpfoyer2.Services;

import tn.esprit.tpfoyer2.Entity.Chambre;
import java.util.*;

public interface IChambreInterface {
    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre c);
    Chambre updateChambre (Chambre  c);
    Optional<Chambre> retrieveChambre (long idChambre);
}