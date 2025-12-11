package tn.esprit.tpfoyer2.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer2.Entity.Universite;
import tn.esprit.tpfoyer2.Services.IUniversiteInterface;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/universites")
@AllArgsConstructor
public class UniversiteController {

    private final IUniversiteInterface universiteService;

    @GetMapping
    public List<Universite> getAllUniversites() {
        return universiteService.retrieveAllUniversities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Universite> getUniversiteById(@PathVariable("id") long id) {
        return universiteService.retrieveUniversite(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Universite> addUniversite(@RequestBody Universite universite) {
        Universite created = universiteService.addUniversite(universite);
        return ResponseEntity.created(URI.create("/universites/" + created.getIdUniversite())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Universite> updateUniversite(@PathVariable("id") long id, @RequestBody Universite universite) {
        universite.setIdUniversite(id);
        Universite updated = universiteService.updateUniversite(universite);
        return ResponseEntity.ok(updated);
    }
}


