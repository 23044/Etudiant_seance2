package supnum_api.supnum.soap.dto;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "GetEtudiantResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetEtudiantResponse {
    private EtudiantSoap etudiant;

    public EtudiantSoap getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(EtudiantSoap etudiant) {
        this.etudiant = etudiant;
    }

}