package tn.esprit.tpfoyer2.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer2.Entity.Etudiant;
import tn.esprit.tpfoyer2.Services.IEtudiantInterface;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/etudiants")
@AllArgsConstructor
public class EtudiantController {

    private final IEtudiantInterface etudiantService;

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.retrieveAllEtudiants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable("id") long id) {
        return etudiantService.retrieveEtudiant(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants) {
        return etudiantService.addEtudiants(etudiants);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable("id") long id, @RequestBody Etudiant etudiant) {
        etudiant.setIdEtudiant(id);
        Etudiant updated = etudiantService.updateEtudiant(etudiant);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable("id") long id) {
        etudiantService.removeEtudiant(id);
        return ResponseEntity.noContent().build();
    }
}


