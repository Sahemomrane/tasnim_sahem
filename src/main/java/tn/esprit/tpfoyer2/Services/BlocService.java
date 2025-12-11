package tn.esprit.tpfoyer2.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer2.Entity.Bloc;
import tn.esprit.tpfoyer2.Repository.BlocRepository;
import java.util.*;
@Service
@AllArgsConstructor
public class BlocService implements IBlocInterface {
    private final BlocRepository br;
    @Override
    public List<Bloc> retrieveBlocs() {
        return br.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return br.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return br.save(bloc);
    }

    @Override
    public Optional<Bloc> retrieveBloc(long idBloc) {
        return br.findById(idBloc);
    }

    @Override
    public void removeBloc(long idBloc) {
        br.deleteById(idBloc);
    }
}
