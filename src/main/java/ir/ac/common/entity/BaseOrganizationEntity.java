package ir.ac.common.entity;



import ir.ac.common.interfaces.OrganizationSupport;
import ir.ac.core.entity.AbstractEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

/**
 * Created by majid on 9/14/16.
 */
@MappedSuperclass
public abstract class BaseOrganizationEntity extends AbstractEntity implements OrganizationSupport {

    private CmOrganization organization;

    @Override
    public void setCmOrganization(CmOrganization organization) {
        this.organization = organization;
    }

    @Override
    @ManyToOne
    @JoinColumn(name = "CM_ORGANIZATION_ID", unique = false, nullable = false, insertable = true, updatable = true)
    public CmOrganization getCmOrganization() {
        return organization;
    }


}
