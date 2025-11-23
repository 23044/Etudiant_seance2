package supnum_api.supnum.service;

import supnum_api.supnum.dto.EtudiantDto;
import supnum_api.supnum.model.Etudiant;
import supnum_api.supnum.repository.EtudiantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
// @RequiredArgsConstructor
public class EtudiantService {
    private final Map<Long, Etudiant> etudiants = new HashMap<>();
    private long nextId = 1;

    @Autowired
    private EtudiantRepository repository;

    // Récupérer tous les étudiants
    public List<Etudiant> getAllEtudiants() {
        return repository.findAll();
    }

    // Récupérer un étudiant par ID
    public Etudiant getEtudiantById(Long id) {
        return repository.findById(id).get();
    }

    // Ajouter un nouvel étudiant
    public Etudiant ajouterEtudiant(EtudiantDto etudiantDto) {
        Etudiant etudiant = new Etudiant();
        etudiant.setAnnee(etudiantDto.getAnnee());
        etudiant.setEmail(etudiantDto.getEmail());
        etudiant.setFiliere(etudiantDto.getFiliere());
        etudiant.setNom(etudiantDto.getNom());
        etudiant.setPrenom(etudiantDto.getPrenom());
        return repository.save(etudiant);
    }

    // Modifier un étudiant
    public Etudiant modifierEtudiant(Long id, Etudiant etudiant) {
        // if (!etudiants.containsKey(id)) {
        // return null;
        // }
        // etudiant.setId(id);
        // etudiants.put(id, etudiant);
        if (repository.findById(id).isPresent()) {
            Etudiant etudiant2 = repository.findById(id).get();
            etudiant2.setNom(etudiant.getNom());
            etudiant2.setPrenom(etudiant.getPrenom());
            etudiant2.setNom(etudiant.getNom());
        }
        return etudiant;
    }

    // Supprimer un étudiant
    public boolean supprimerEtudiant(Long id) {
        return etudiants.remove(id) != null;
    }
}
