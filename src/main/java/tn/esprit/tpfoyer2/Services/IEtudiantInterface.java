package tn.esprit.tpfoyer2.Services;

import tn.esprit.tpfoyer2.Entity.Etudiant;
import java.util.*;

public interface IEtudiantInterface {
    List<Etudiant> retrieveAllEtudiants();
    List<Etudiant> addEtudiants (List<Etudiant> etudiants);
    Etudiant updateEtudiant (Etudiant e);
    Optional<Etudiant> retrieveEtudiant(long idEtudiant);
    void removeEtudiant(long idEtudiant);
}
