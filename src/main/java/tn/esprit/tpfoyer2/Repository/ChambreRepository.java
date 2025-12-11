package tn.esprit.tpfoyer2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer2.Entity.Chambre;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {
}
