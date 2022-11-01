package ir.ac.common.entity;



import ir.ac.core.annotation.UsecaseSupport;
import ir.ac.core.enumration.SubSystem;
import ir.ac.core.enumration.UsecaseType;

import javax.persistence.*;

/**
 * Created by majid on 8/16/16.
 */
@Entity
@Table(name = "CM_ORGANIZATON_NATURE")
@NamedQueries({
        @NamedQuery(name = "findOrganizationNatureByKey",query = "select organizationNature from CmOrganizationNature organizationNature where organizationNature.key like :natureKey")
})
@UsecaseSupport(subSystem = SubSystem.Common,usecaseType = UsecaseType.Process)
public class CmOrganizationNature extends AbstractCmOrganizationNature {
    public CmOrganizationNature() {
    }
}
