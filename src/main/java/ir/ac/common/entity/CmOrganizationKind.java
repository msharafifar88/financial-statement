package ir.ac.common.entity;


import ir.ac.core.annotation.UsecaseSupport;
import ir.ac.core.enumration.SubSystem;
import ir.ac.core.enumration.UsecaseType;

import javax.persistence.*;

/**
 * Created by majid on 9/4/17.
 */
@Entity
@Table(name = "CM_ORGANIZATION_KIND")
@NamedQueries({
        @NamedQuery(name = "findLastOrganizationKindCode", query = "select max(organizationKind.code) from CmOrganizationKind organizationKind order by organizationKind.code desc"),
        @NamedQuery(name = "countOrganizationKindByNameOrCode",query = "select count(organizationKind) from CmOrganizationKind organizationKind where organizationKind.name=:name or organizationKind.code=:code"),
        @NamedQuery(name = "countOrganizationKindByNameOrCodeForEdit",query = "select count(organizationKind) from CmOrganizationKind organizationKind where organizationKind.id not in :id and (organizationKind.name like :name or organizationKind.code like :code)"),
})
@Cacheable
@UsecaseSupport(subSystem = SubSystem.Common,usecaseType = UsecaseType.Process)
public class CmOrganizationKind extends AbstractCmOrganizationKind {
}
