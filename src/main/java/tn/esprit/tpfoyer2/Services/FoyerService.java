package tn.esprit.tpfoyer2.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer2.Entity.Foyer;
import tn.esprit.tpfoyer2.Repository.FoyerRepository;
import java.util.*;
@Service
@AllArgsConstructor
public class FoyerService implements IFoyerInterface {
    private final FoyerRepository fr;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return fr.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return fr.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return fr.save(f);
    }

    @Override
    public Optional<Foyer> retrieveFoyer(long idFoyer) {
        return fr.findById(idFoyer);
    }

    @Override
    public void removeFoyer(long idFoyer) {
        fr.deleteById(idFoyer);
    }
}