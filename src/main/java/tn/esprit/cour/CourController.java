package tn.esprit.cour;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cours")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CourController {

    private final CourService courService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Cour cour){
        courService.saveCour(cour);
    }

    @GetMapping
    public ResponseEntity<List<Cour>> findAllCours(){
        return ResponseEntity.ok(courService.findAllCours());
    }

    @GetMapping("/with-planning/{cour-id}")
    public ResponseEntity<FullCourResponse> findAllCours(@PathVariable("cour-id") Integer courId){

        return ResponseEntity.ok(courService.findCoursWithPlannings(courId));
    }

    @GetMapping("afficher/{id}")
    public ResponseEntity<Cour> getCourById(@PathVariable Integer id) {
        Cour cour = courService.getCourById(id);
        if (cour != null) {
            return new ResponseEntity<>(cour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Cour> updateCour(@PathVariable Integer id, @RequestBody Cour cour) {
        Cour updatedCour = courService.updateCour(id, cour);
        if (updatedCour != null) {
            return new ResponseEntity<>(updatedCour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> deleteCour(@PathVariable Integer id) {
        courService.deleteCour(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/importer-fichier")
    public String importerFichier(@RequestParam("file") MultipartFile file) {
        // Logique pour traiter le fichier
        if (!file.isEmpty()) {
            // Vous pouvez traiter le fichier ici
            return "Fichier importé avec succès : " + file.getOriginalFilename();
        } else {
            return "Échec de l'importation du fichier : fichier vide.";
        }
    }
}
