package supnum_api.supnum.soap.dto;

import jakarta.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(name = "GetAllEtudiantsResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAllEtudiantsResponse {

    @XmlElement(name = "etudiant")
    private List<EtudiantSoap> etudiant = new ArrayList<>();

    public List<EtudiantSoap> getEtudiant() {
        return etudiant;
    }
}
