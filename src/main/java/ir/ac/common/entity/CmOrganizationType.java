package ir.ac.common.entity;




import ir.ac.common.interfaces.CmIndependent;
import ir.ac.core.annotation.UsecaseSupport;
import ir.ac.core.enumration.SubSystem;
import ir.ac.core.enumration.UsecaseType;

import javax.persistence.*;

/**
 * Created by majid on 6/23/16.
 */
@Entity
@Table(name = "CM_ORGANIZATION_TYPE")
@NamedQueries({
        @NamedQuery(name = "findOrganizationTypeByCode",query = "select organizationType from CmOrganizationType organizationType where organizationType.code like :code")
})
@Cacheable
@UsecaseSupport(subSystem = SubSystem.Common,usecaseType = UsecaseType.Process)
public class CmOrganizationType extends AbstractCmOrganizationType implements CmIndependent {

    public CmOrganizationType() {
    }
}
