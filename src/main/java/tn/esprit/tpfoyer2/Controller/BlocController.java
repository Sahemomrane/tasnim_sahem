 package tn.esprit.tpfoyer2.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer2.Entity.Bloc;
import tn.esprit.tpfoyer2.Services.IBlocInterface;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/blocs")
@AllArgsConstructor
public class BlocController {

    private final IBlocInterface blocService;

    @GetMapping
    public List<Bloc> getAllBlocs() {
        return blocService.retrieveBlocs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bloc> getBlocById(@PathVariable("id") long id) {
        return blocService.retrieveBloc(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Bloc> addBloc(@RequestBody Bloc bloc) {
        Bloc created = blocService.addBloc(bloc);
        return ResponseEntity.created(URI.create("/blocs/" + created.getIdBloc())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bloc> updateBloc(@PathVariable("id") long id, @RequestBody Bloc bloc) {
        bloc.setIdBloc(id);
        Bloc updated = blocService.updateBloc(bloc);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloc(@PathVariable("id") long id) {
        blocService.removeBloc(id);
        return ResponseEntity.noContent().build();
    }
}


