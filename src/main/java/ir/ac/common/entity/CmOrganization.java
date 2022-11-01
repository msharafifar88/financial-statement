package ir.ac.common.entity;

import ir.ac.common.interfaces.CmIndependent;
import ir.ac.core.annotation.UsecaseSupport;
import ir.ac.core.enumration.SubSystem;
import ir.ac.core.enumration.UsecaseType;
import ir.ac.core.interfaces.TreeNode;


import javax.persistence.*;

/**
 * Created by majid on 6/22/16.
 */
@Entity
@Cacheable
@Table(name = "CM_ORGANIZATION")
@NamedQueries({
            @NamedQuery(name = "findByOrganizationName",query = "select organization from CmOrganization organization where organization.name like :name and organization.active=:active"),
            @NamedQuery(name = "findAllActiveOrganization",query = "select organization from CmOrganization organization where organization.active=:active"),
            @NamedQuery(name = "findListByOrganizationName",query = "select organization from CmOrganization organization where organization.name like :name and organization.pathCode like:path and organization.active=:active order by organization.codeDigit asc "),
            @NamedQuery(name = "findListByOrganizationCode",query = "select organization from CmOrganization organization where organization.codeDigit=:code and organization.pathCode like:path and organization.active=:active order by organization.codeDigit asc "),
            @NamedQuery(name = "findOrganizationByParent", query = "select organization from CmOrganization organization where organization.parent=:parent and organization.active=:active order by organization.name "),
            @NamedQuery(name = "findOrganizationByChildren" , query = "select organization from CmOrganization organization where organization.parent=:parent and organization.active=:active"),
            @NamedQuery(name = "findOrganizationByCode", query = "select organization from CmOrganization organization where organization.codeDigit=:code  and organization.active=:active order by organization.name "),
            @NamedQuery(name = "findOrganizationByPath",query = "select organization from CmOrganization organization where organization.pathCode like :path and organization.active=:active"),
            @NamedQuery(name = "findAllOrganization",query = "select organization from CmOrganization organization where organization.active=:active order by organization.codeDigit asc "),
            @NamedQuery(name = "findOrganizationByPathcode",query = "select organization from CmOrganization organization where organization.pathCode like :code and organization.active=:active"),
            @NamedQuery(name = "countOrganizationByNameOrCodeForEdit" , query = "select count (organization) from CmOrganization organization where organization.id not in :id and (organization.name=:name or organization.codeDigit=:code) and organization.parent=:parent and organization.active=:active"),
            @NamedQuery(name = "countOrganizationByName" , query = "select count (organization) from CmOrganization organization where organization.name=:name and organization.parentId=:parentId"),
            @NamedQuery(name = "countOrganizationByCode" , query = "select count (organization) from CmOrganization organization where organization.codeDigit=:code"),
            @NamedQuery(name = "countOrganizationByCodeForEdit" , query = "select count (organization) from CmOrganization organization where organization.id not in :id and organization.codeDigit=:code"),
            @NamedQuery(name = "countOrganizationByNameForEdit" , query = "select count (organization) from CmOrganization organization where organization.id not in :id and organization.name=:name and organization.parentId=:parentId"),
//            @NamedQuery(name = "findAllOrganizationWithAccountingType",query = "select organization from CmOrganization organization where organization.id in (select accountingTypeOrganization.organization.id from AcAccountingTypeOrganization accountingTypeOrganization) and organization.pathCode like:path and organization.active=:active"),
            @NamedQuery(name = "findByIndependentAccounting",query = "select organization from CmOrganization organization where organization.organizationNatureEnum =:organizationNature and organization.active=:active order by organization.codeDigit asc"),
            @NamedQuery(name = "findByIndependentAccountingAndAccounting",query = "select organization from CmOrganization organization where organization.organizationNatureEnum =:organizationNature and organization.accounting=:accounting and organization.active=:active order by organization.codeDigit asc"),
            @NamedQuery(name = "findByIndependentAccountingAndAccountingByParentOrganization",query = "select organization from CmOrganization organization where organization.pathCode like :pathCode and organization.organizationNatureEnum =:organizationNature and organization.accounting=:accounting and organization.active=:active order by organization.codeDigit asc"),
            @NamedQuery(name = "findByIndependentAccountingWihoutCurrentOrganization",query = "select organization from CmOrganization organization where organization.id != :id and organization.organizationNatureEnum =:organizationNature and organization.active=:active"),
//            @NamedQuery(name = "findByListNotifyMaster",query = "select organization from CmOrganization organization where organization.active=:active and organization.id in(select documentSubDetail.independentId from AcDocumentSubDetail documentSubDetail where documentSubDetail.documentDetail in(select documentDetail from AcDocumentDetail documentDetail where documentDetail in(select notifyDetail.documentDetail from TrNotifyDetail notifyDetail where notifyDetail.notifyMaster=:notifyMaster))and documentSubDetail.clazz=:clazz)"),
//            @NamedQuery(name = "findListIndependentAccountingByName", query = "select organization from CmOrganization organization where organization.name like :name and organization.organizationNatureEnum =:organizationNature and organization.active=:active"),
//            @NamedQuery(name = "findListIndependentAccountingByCode", query = "select organization from CmOrganization organization where organization.codeDigit=:code and organization.organizationNatureEnum =:organizationNature and organization.active=:active"),
            @NamedQuery(name = "countByOrganizationKind", query = "select count(organization) from CmOrganization  organization where organization.organizationKind=:organizationKind"),
            @NamedQuery(name = "findOrganizationByIndependentAccounting",query = "select organization from CmOrganization organization where organization.pathCode like :pathCode and organization.organizationNatureEnum =:organizationNature and organization.active=:active order by organization.codeDigit asc"),
//            @NamedQuery(name = "findOrganizationByIndependentAccountingNotInAccountingTypeOrganization",query = "select organization from CmOrganization organization where organization.pathCode like :pathCode and organization.organizationNatureEnum =:organizationNature and organization.active=:active and organization.id not in (select accountingTypeOrganization.organization from AcAccountingTypeOrganization accountingTypeOrganization where accountingTypeOrganization.accountingTypeId=:accountingTypeId) order by organization.codeDigit asc"),
            @NamedQuery(name = "findOrganizationsByIndependentAccounting",query = "select organization from CmOrganization organization where organization.organizationNatureEnum =:organizationNature and organization.active=:active order by organization.codeDigit asc"),
            @NamedQuery(name = "findOrganizationByIndependentAccountingOrderByPath",query = "select organization from CmOrganization organization where organization.pathCode like :pathCode and organization.organizationNatureEnum =:organizationNature and organization.active=:active order by organization.pathCode asc"),
            @NamedQuery(name = "findIndependentAccountOrganizationsByName",query = "select organization from CmOrganization organization where organization.name like :name and organization.pathCode like :pathCode and organization.organizationNatureEnum =:organizationNature and organization.active=:active"),
            @NamedQuery(name = "findIndependentAccountOrganizationsByCode",query = "select organization from CmOrganization organization where organization.codeDigit=:code and organization.pathCode like :pathCode and organization.organizationNatureEnum =:organizationNature and organization.active=:active"),
//            @NamedQuery(name = "findIndependentAccountOrgByName",query = "select organization from CmOrganization organization where organization.name like :name and organization.organizationNatureEnum =:organizationNature and organization.active=:active"),
//            @NamedQuery(name = "findIndependentAccountOrgByCode",query = "select organization from CmOrganization organization where organization.codeDigit=:code and organization.organizationNatureEnum =:organizationNature and organization.active=:active"),
//            @NamedQuery(name = "findCostCenterByOrganization" , query = "select organization.costCenter from CmOrganization organization where organization=:organization"),
            @NamedQuery(name = "countActiveChildOrganizationByParent", query = "select count(organization) from CmOrganization organization inner join organization.children child where child.pathCode like :pathCode and child.active=true "),
            @NamedQuery(name = "findOrganizationByIndependentAccountingOrDependent",query = "select organization from CmOrganization organization where organization.pathCode like :pathCode and (organization.organizationNatureEnum =:organizationNature or organization.organizationNatureEnum =:secondOrganizationNature) and organization.active=:active order by organization.codeDigit asc"),
            @NamedQuery(name = "findOrganizationByDependent",query = "select  organization from CmOrganization organization where organization.pathCode like :pathCode and organization.organizationNatureEnum =:organizationNature and organization.active=:active order by organization.pathCode asc"),
            @NamedQuery(name = "countOrganizationById",query = "select count(organization) from CmOrganization organization where organization.id=:id"),
            @NamedQuery(name = "disableEnableOrganization",query = "update CmOrganization organization set organization.active=:active where organization.pathCode=:pathcode or organization.pathCode like :pathCode"),
//            @NamedQuery(name = "findOrganizationsWithStatement" , query = "select organization from CmOrganization organization where organization.active=:active and organization.id in (select statement.organization from HrStatement statement where statement.personnel=:personnel)"),
            @NamedQuery(name = "findOrganizationNameById", query = "select organization.name from CmOrganization organization where organization.id=:id"),
            @NamedQuery(name = "findLastLevelOrganizationByPathcode",query = "select organization from CmOrganization organization where organization.pathCode like :pathcode  and organization.leaf=:leaf  and organization.active=:active"),
            @NamedQuery(name = "findParentOrganization" , query = "select organization from CmOrganization organization where organization.parent is null")

})
@NamedStoredProcedureQueries    ({
        @NamedStoredProcedureQuery(name = "organizationPathFix",procedureName = "CM_SP_SET_PATH_CODE_ID",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "P_ID"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "P_Parent_ID_Old")
                }),
        @NamedStoredProcedureQuery(name = "organizationJSONPathFix",procedureName = "CM_SP_ORGAN_FIX_JSON_PATH",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "P_Ids")
                })
})


@UsecaseSupport(subSystem = SubSystem.Common,usecaseType = UsecaseType.Process)
public class CmOrganization extends AbstractCmOrganization implements CmIndependent, TreeNode {

    /** default constructor */
    public CmOrganization() {
    }

    public CmOrganization(CmOrganization organization) {

    }
}
