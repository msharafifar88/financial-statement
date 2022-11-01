package ir.ac.common.rest;

import ir.ac.common.dao.OrganizationDao;
import ir.ac.common.entity.CmOrganization;
import ir.ac.common.enumration.OrganizationNatureEnum;
import ir.ac.common.rest.wrapper.OrganizationWrapper;
import ir.ac.common.service.OrganizationService;
import ir.ac.core.utils.TreesUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("/organization")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrganizationRestService {

    private List<CmOrganization> organizations;

    @Inject
    private OrganizationService organizationService;

    @Inject
    TreesUtils treesUtils;

    @PostConstruct
    public void init() {
        organizations = (organizationService.findAll());
        organizations =treesUtils.convert(organizations);
    }

    @GET
    @Path("/list")
    public List<OrganizationWrapper> getAllOrganization(){
        List<OrganizationWrapper> organizationWrappers = new ArrayList<>();

        organizations.forEach(organization -> {
            organizationWrappers.add(new OrganizationWrapper(organization));
        });

        return organizationWrappers;
    }
    @GET
    @Path("/indepententorganization")
    public List<OrganizationWrapper> findIndependentOrganization(){
        List<OrganizationWrapper> organizationWrappers = new ArrayList<>();
        organizations.forEach(organization -> {
            if(organization.getOrganizationNatureEnum().equals(OrganizationNatureEnum.IndependentAccounting) ){
                organizationWrappers.add(new OrganizationWrapper(organization));
            }

        });
        return organizationWrappers;
    }
    @GET
    @Path("/list/{id}")
    public OrganizationWrapper findByIDOrganization(@PathParam("id") Long id){
        CmOrganization organization =organizations.stream().filter(cmOrganization -> cmOrganization.getId().equals(id)).findFirst().orElseGet(CmOrganization::new);
        return new OrganizationWrapper(organization);
    }
}
