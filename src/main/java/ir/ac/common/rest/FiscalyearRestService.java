package ir.ac.common.rest;

import ir.ac.common.entity.CmFiscalyear;
import ir.ac.common.service.FiscalyearService;
import ir.ac.common.wrapper.FiscalYearWrapper;
import ir.ac.core.exception.DuplicateDataException;
import ir.ac.core.exception.RelationDataException;
import ir.ac.core.exception.SaveRecordException;
import ir.ac.financialStatement.entity.FSConfiguration;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.List;

@RequestScoped
@Path("/year")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FiscalyearRestService {
    @Inject
    FiscalyearService fiscalyearService;

    @GET
    @Path("/list")
    public List<CmFiscalyear> getConfiguration(){
        return fiscalyearService.findAll();
    }

    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id){
        try {
            fiscalyearService.delete(id);
        } catch (RelationDataException e) {
            throw new RuntimeException(e);
        } catch (SaveRecordException e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/update")
    public void update(CmFiscalyear fiscalyear){
        try {
            fiscalyearService.edit(fiscalyear);
        } catch (DuplicateDataException e) {
            throw new RuntimeException(e);
        } catch (RelationDataException e) {
            throw new RuntimeException(e);
        } catch (SaveRecordException e) {
            throw new RuntimeException(e);
        }


    }
    @POST
    @Path("/create")
    public void create(FiscalYearWrapper fiscalYearWrapper) {
        fiscalYearWrapper.get_code();
        try {
            CmFiscalyear year =new CmFiscalyear();
            year.setName(fiscalYearWrapper.get_name());
            year.setCode(fiscalYearWrapper.get_code());
            year.setStartDate(LocalDateTime.now());
            year.setEndDate(LocalDateTime.now());
            fiscalyearService.create(year);
        } catch (Exception e) {
        }
    }

}
