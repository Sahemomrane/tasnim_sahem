package tn.esprit.tpfoyer2.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer2.Entity.Chambre;
import tn.esprit.tpfoyer2.Services.IChambreInterface;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/chambres")
@AllArgsConstructor
public class ChambreController {

    private final IChambreInterface chambreService;

    @GetMapping
    public List<Chambre> getAllChambres() {
        return chambreService.retrieveAllChambres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chambre> getChambreById(@PathVariable("id") long id) {
        return chambreService.retrieveChambre(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Chambre> addChambre(@RequestBody Chambre chambre) {
        Chambre created = chambreService.addChambre(chambre);
        return ResponseEntity.created(URI.create("/chambres/" + created.getIdChambre())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chambre> updateChambre(@PathVariable("id") long id, @RequestBody Chambre chambre) {
        chambre.setIdChambre(id);
        Chambre updated = chambreService.updateChambre(chambre);
        return ResponseEntity.ok(updated);
    }
}


