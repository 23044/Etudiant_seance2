package supnum_api.supnum.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EtudiantDto {
    private String nom;
    private String prenom;
    private String email;
    private String filiere;
    private int annee;
}