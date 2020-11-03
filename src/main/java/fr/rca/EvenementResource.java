package fr.rca;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Path(ResourceConstante.VERSION_1 + ResourceConstante.ENDPOINT_EVENEMENT)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EvenementResource {

    private final EvenementService evenementService;

    public EvenementResource(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @GET
    public List<Evenement> list() {
        return evenementService.getEvenements();
    }

    @GET
    @Path("/{id}")
    public Response evenement(@PathParam("id") Long id) {

        Optional<Evenement> optionalEvenement = evenementService.getEvenement(id);

        if (optionalEvenement.isPresent()) {
            return Response.ok(optionalEvenement.get()).build();
        } else {

            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response add(NewEvenement newEvenement) {


        Optional<Evenement> resultat = evenementService.add(newEvenement);

        if (resultat.isPresent()) {
            try {
                return Response.seeOther(
                        new URI(
                                ResourceConstante.VERSION_1 +
                                        ResourceConstante.ENDPOINT_EVENEMENT +
                                        ResourceConstante.SEPARATOR + resultat.get().getId()))
                        .build();
            } catch (URISyntaxException exception) {
                return Response.serverError().build();
            }
        } else {
            return Response.serverError().build();
        }

    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {

        try {
            Long resultat = evenementService.delete(id);

            if (resultat.equals(0L)) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
