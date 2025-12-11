package tn.esprit.tpfoyer2.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer2.Entity.Etudiant;
import tn.esprit.tpfoyer2.Repository.EtudiantRepository;
import java.util.*;
@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantInterface {
    private final EtudiantRepository er;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return er.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return er.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return er.save(e);
    }

    @Override
    public Optional<Etudiant> retrieveEtudiant(long idEtudiant) {
        return er.findById(idEtudiant);
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        er.deleteById(idEtudiant);
    }
}
