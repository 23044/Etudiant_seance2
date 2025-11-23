package supnum_api.supnum.soap.dto;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "GetEtudiantRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetEtudiantRequest {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
