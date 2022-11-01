package ir.ac.financialStatement.rest;

import ir.ac.common.service.FiscalyearService;
import ir.ac.common.service.OrganizationService;
import ir.ac.financialStatement.entity.FSFinancialStatement;
import ir.ac.financialStatement.rest.wrapper.FSWrapper;
import ir.ac.financialStatement.service.FSService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("fs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FSRestService {
    @Inject
    private FSService fsService;
    @Inject
    private FiscalyearService fiscalyearService;
    @Inject
    private OrganizationService organizationService;

    /* Rest Get Method*/
    @GET
    @Path("/list")
    public List<FSWrapper> getAll() {
        List<FSWrapper> fsWrapperList = new ArrayList<>();
        List<FSFinancialStatement> fsFinancialStatements= fsService.findAll();
        for (FSFinancialStatement fsFinancialStatement : fsFinancialStatements) {
            fsWrapperList.add(new FSWrapper(fsFinancialStatement.getId(), fsFinancialStatement.getCode(),fsFinancialStatement.getName()
                    ,fsFinancialStatement.getCmOrganization().getId(),fsFinancialStatement.getCmOrganization().getName(),fsFinancialStatement.getCmOrganization().getCode(),
                    fsFinancialStatement.getCmFiscalyear().getId(),fsFinancialStatement.getCmFiscalyear().getName(),fsFinancialStatement.getCmFiscalyear().getCode()));

        }
        return fsWrapperList;
    }

    /* Rest Create Method*/
    @POST
    @Path("/create")
    public FSFinancialStatement create(FSWrapper fsWrapper) {
        FSFinancialStatement fsFinancialStatement =fsWrapper.createFSFinancialStatement(fsWrapper,
                 organizationService.findOrganizationByID(fsWrapper.get_organizationID()),
                fiscalyearService.findByID(fsWrapper.get_yearID()));


        fsService.create(fsFinancialStatement);
        return fsFinancialStatement;
    }

    /* Rest Edit Method*/
    @PUT
    @Path("/edit/{id}")
    public FSFinancialStatement edit(@PathParam("id") Long id, FSWrapper fsWrapper) {
        FSFinancialStatement fsFinancialStatement = fsService.findByID(id);
        organizationService.findOrganizationByID(fsWrapper.get_organizationID());
        fiscalyearService.findByID(fsWrapper.get_yearID());
        fsService.edit(fsFinancialStatement);
        return fsFinancialStatement;
    }

    /* Rest Delete Method*/
    @DELETE
    @Path("/delete/{id}")
    public boolean delete(@PathParam("id") Long id) {
        return fsService.delete(id);
    }

}
