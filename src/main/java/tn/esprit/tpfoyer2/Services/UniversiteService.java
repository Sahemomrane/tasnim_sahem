package tn.esprit.tpfoyer2.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer2.Entity.Universite;
import tn.esprit.tpfoyer2.Repository.UniversiteRepository;
import java.util.*;
@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteInterface {
    private final UniversiteRepository ur;
    @Override
    public List<Universite> retrieveAllUniversities() {
        return ur.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return ur.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return ur.save(u);
    }

    @Override
    public Optional<Universite> retrieveUniversite(long idUniversite) {
        return ur.findById(idUniversite);
    }
}
