package tn.esprit.tpfoyer2.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer2.Entity.Chambre;
import tn.esprit.tpfoyer2.Repository.ChambreRepository;
import java.util.*;
@Service
@AllArgsConstructor
public class ChambreService implements  IChambreInterface {
    private final ChambreRepository cr;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return cr.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return cr.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return cr.save(c);
    }

    @Override
    public Optional<Chambre> retrieveChambre(long idChambre) {
        return cr.findById(idChambre);
    }
}
