package supnum_api.supnum.controller;

import supnum_api.supnum.dto.EtudiantDto;
// import supnum_api.supnum.controller.EtudiantController.EtudiantNotFoundException;
import supnum_api.supnum.model.Etudiant;
import supnum_api.supnum.service.EtudiantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    // GET /api/etudiants - Liste tous les étudiants // Reutilisable
    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    // GET /api/etudiants/{id} - Récupère un étudiant par ID
    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        if (etudiant == null) {
            System.out.println("Etudiant Not found");
        }
        return etudiant;
    }

    // POST /api/etudiants - Créer un nouvel étudiant
    @PostMapping
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody EtudiantDto etudiant) {
        Etudiant nouvelEtudiant = etudiantService.ajouterEtudiant(etudiant);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelEtudiant);
    }

    // PUT /api/etudiants/{id} - Modifier un étudiant
    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(
            @PathVariable Long id,
            @RequestBody Etudiant etudiant) {
        Etudiant etudiantModifie = etudiantService.modifierEtudiant(id, etudiant);
        if (etudiantModifie == null) {
            System.out.println("Etudiant Not found");
        }
        return ResponseEntity.ok(etudiantModifie);
    }

    // DELETE /api/etudiants/{id} - Supprimer un étudiant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
        boolean supprime = etudiantService.supprimerEtudiant(id);
        if (!supprime) {
            System.out.println("Etudiant Not found");
        }
        return ResponseEntity.noContent().build();
    }
}