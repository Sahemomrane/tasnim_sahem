package tn.esprit.tpfoyer2.Services;
import tn.esprit.tpfoyer2.Entity.Bloc;
import java.util.*;

public interface IBlocInterface {
    List<Bloc> retrieveBlocs();
    Bloc updateBloc (Bloc  bloc);
    Bloc addBloc (Bloc bloc);
    Optional<Bloc> retrieveBloc (long  idBloc);
    void removeBloc (long idBloc);

}
