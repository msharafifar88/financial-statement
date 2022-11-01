package ir.ac.financialStatement.rest;

import ir.ac.common.entity.CmFiscalyear;
import ir.ac.financialStatement.entity.FSConfiguration;
import ir.ac.financialStatement.service.FSConfigurationService;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Path("/fsconfig")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FSConfigurationRestService {
    FSConfigurationService fsConfigurationService;

    @POST
    @Path("/create")
    public FSConfiguration postConfiguration(FSConfiguration configuration){
        fsConfigurationService.createConfiguration(configuration);
        return configuration;
    }
    @PUT
    @Path("update/{id}")
    public FSConfiguration putConfiguration(FSConfiguration configuration){
        fsConfigurationService.editConfiguration(configuration);
        return configuration;
    }
    @DELETE
    @Path("{id}")
    public Response deleteConfiguration(@PathParam("id") Long id){

        try {
            fsConfigurationService.deleteConfiguration(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).status(Response.Status.BAD_REQUEST).build();
        }

    }
    @GET
    @Path("/list")
    public Response getConfiguration(){
        try {
            return Response.ok().entity(fsConfigurationService.findAll()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).status(Response.Status.BAD_REQUEST).build();
        }

    }
}
