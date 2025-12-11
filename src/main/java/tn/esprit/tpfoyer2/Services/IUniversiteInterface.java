package tn.esprit.tpfoyer2.Services;

import tn.esprit.tpfoyer2.Entity.Universite;
import java.util.*;

public interface IUniversiteInterface {
    List<Universite> retrieveAllUniversities();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Optional<Universite> retrieveUniversite (long idUniversite);
}
