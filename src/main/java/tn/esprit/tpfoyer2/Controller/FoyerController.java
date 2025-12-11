package tn.esprit.tpfoyer2.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer2.Entity.Foyer;
import tn.esprit.tpfoyer2.Services.IFoyerInterface;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/foyers")
@AllArgsConstructor
public class FoyerController {

    private final IFoyerInterface foyerService;

    @GetMapping
    public List<Foyer> getAllFoyers() {
        return foyerService.retrieveAllFoyers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foyer> getFoyerById(@PathVariable("id") long id) {
        return foyerService.retrieveFoyer(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Foyer> addFoyer(@RequestBody Foyer foyer) {
        Foyer created = foyerService.addFoyer(foyer);
        return ResponseEntity.created(URI.create("/foyers/" + created.getIdFoyer())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Foyer> updateFoyer(@PathVariable("id") long id, @RequestBody Foyer foyer) {
        foyer.setIdFoyer(id);
        Foyer updated = foyerService.updateFoyer(foyer);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoyer(@PathVariable("id") long id) {
        foyerService.removeFoyer(id);
        return ResponseEntity.noContent().build();
    }
}


