package supnum_api.supnum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import supnum_api.supnum.model.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{
    
    // @Query("Select * from etudiant")
    // List<Etudiant> listEtudaiant();

}