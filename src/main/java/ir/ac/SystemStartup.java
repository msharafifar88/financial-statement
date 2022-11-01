package ir.ac;

import io.quarkus.runtime.Startup;
import ir.ac.common.entity.CmFiscalyear;
import ir.ac.common.entity.CmOrganization;
import ir.ac.common.enumration.OrganizationNatureEnum;
import ir.ac.common.service.FiscalyearService;
import ir.ac.common.service.OrganizationService;
import ir.ac.core.exception.DuplicateDataException;
import ir.ac.core.exception.SaveRecordException;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
@Startup
public class SystemStartup {
    @Inject
    FiscalyearService fiscalyearService;
    @Inject
    OrganizationService organizationService;

    @PostConstruct
    public void init() {

        //initFiscalyear();
        //initOrganization();
    }

    private void initFiscalyear() {
       try {
           for (int i = 1395; i <1405 ; i++) {
               CmFiscalyear fiscalyear = new CmFiscalyear();
               fiscalyear.setActive(true);
               fiscalyear.setCode(String.valueOf(i));
                fiscalyear.setName(String.valueOf(i)+"سال مالی");
                fiscalyear.setStartDate(LocalDateTime.now());
                fiscalyear.setEndDate(LocalDateTime.now().plusYears(1));

               fiscalyearService.create(fiscalyear);
           }
       }catch (Exception e){
           e.printStackTrace();
       }


    }

    private void initOrganization(){
        CmOrganization organization = new CmOrganization();
        organization.setCodeDigit(1l);
        organization.setName("دانشگاه ");
        organization.setActive(true);
        organization.setOrganizationNatureEnum(OrganizationNatureEnum.IndependentAccounting);

        try {
            organizationService.create(organization);
        } catch (DuplicateDataException e) {
            e.printStackTrace();
        } catch (SaveRecordException e) {
            e.printStackTrace();
        }
    }
}
