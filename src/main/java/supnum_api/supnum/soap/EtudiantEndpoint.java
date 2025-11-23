package supnum_api.supnum.soap;

import supnum_api.supnum.model.Etudiant;
import supnum_api.supnum.service.EtudiantService;
import supnum_api.supnum.soap.dto.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EtudiantEndpoint {

    private static final String NAMESPACE = "http://supnum.com/etudiant";

    private final EtudiantService service;

    public EtudiantEndpoint(EtudiantService service) {
        this.service = service;
    }

    // Helper mapping
    private EtudiantSoap toSoap(Etudiant e) {
        EtudiantSoap soap = new EtudiantSoap();
        soap.setId(e.getId());
        soap.setNom(e.getNom());
        soap.setPrenom(e.getPrenom());
        soap.setEmail(e.getEmail());
        soap.setFiliere(e.getFiliere());
        soap.setAnnee(e.getAnnee());
        return soap;
    }

    // 1. GetEtudiant
    @PayloadRoot(namespace = NAMESPACE, localPart = "GetEtudiantRequest")
    @ResponsePayload
    public GetEtudiantResponse getEtudiant(@RequestPayload GetEtudiantRequest request) {
        Etudiant etu = service.getEtudiantById(request.getId());

        GetEtudiantResponse response = new GetEtudiantResponse();
        response.setEtudiant(toSoap(etu));

        return response;
    }

    // 2. GetAllEtudiants
    @PayloadRoot(namespace = NAMESPACE, localPart = "GetAllEtudiantsRequest")
    @ResponsePayload
    public GetAllEtudiantsResponse getAll(@RequestPayload GetAllEtudiantsRequest req) {

        GetAllEtudiantsResponse resp = new GetAllEtudiantsResponse();

        for (Etudiant e : service.getAllEtudiants()) {
            resp.getEtudiant().add(toSoap(e));
        }

        return resp;
    }
}
