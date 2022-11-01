package ir.ac.common.dao;


import ir.ac.common.entity.*;
import ir.ac.common.enumration.OrganizationNatureEnum;
import ir.ac.core.dao.AbstractDAO;
import ir.ac.core.utils.PersianUTF;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by majid on 6/22/16.
 */
@RequestScoped
public class OrganizationDao extends AbstractDAO<CmOrganization> {

    @Inject
    protected EntityManager entityManager;

    @Override
    protected EntityManager entityManager() {
        return entityManager;
    }


    /*public List<CmOrganization> findAllOrganizationWithAccountingType(CmOrganization organization) {
        try {
            Query query = getEntityManager().createNamedQuery("findAllOrganizationWithAccountingType");
            query.setParameter("path", organization.getPathCode() + "%");
            query.setParameter("active", true);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }*/

    public CmOrganization findById(Long id){
        try {
            return entityManager().find(CmOrganization.class, id);
        }catch (Exception e){
            return null;
        }
    }
    public CmOrganization findByName(String name) {
        try {
            Query query = entityManager().createNamedQuery("findByOrganizationName");
            query.setParameter("name", name);
            query.setParameter("active", true);
            return (CmOrganization) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public List<CmOrganization> findListByName(CmOrganization organization, String name) {
        try {
            Query query = entityManager().createNamedQuery("findListByOrganizationName");
            query.setParameter("name", "%" + name + "%");
            query.setParameter("path", organization.getPathCode() + "%");
            query.setParameter("active", true);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public List<CmOrganization> findListByCode(CmOrganization organization, Long code) {
        try {
            Query query = entityManager().createNamedQuery("findListByOrganizationCode");
            query.setParameter("code", code);
            query.setParameter("path", organization.getPathCode() + "%");
            query.setParameter("active", true);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public List<CmOrganization> findAllActive() {
        try {
            Query query = entityManager().createNamedQuery("findAllActiveOrganization");
            query.setParameter("active", true);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public CmOrganization findByCode(Long code) {
        try {
            Query query = entityManager().createNamedQuery("findOrganizationByCode");
            query.setParameter("code", code);
            query.setParameter("active", true);
            return (CmOrganization) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<CmOrganization> findOrganizationByPathcode(CmOrganization organization) {
        try {
            Query query = entityManager().createNamedQuery("findOrganizationByPathcode");
            query.setParameter("code", organization.getPathCode() + "%");
            query.setParameter("active", true);
            return query.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<CmOrganization> findOrganizationByPathcode(String organizationPathCode) {
        try {
            Query query = entityManager().createNamedQuery("findOrganizationByPathcode");
            query.setParameter("code", organizationPathCode + "%");
            query.setParameter("active", true);
            return query.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<CmOrganization> findOrganizationByParent(CmOrganization organization) {
        Query query = entityManager().createNamedQuery("findOrganizationByParent");
        query.setParameter("parent", organization);
        query.setParameter("active", true);
        query.setHint("org.hibernate.cacheable", true);
        return query.getResultList();
    }

    public List<CmOrganization> findByPath(String path) {
        Query query = entityManager().createNamedQuery("findOrganizationByPath");
        query.setParameter("path", path);
        query.setParameter("active", true);
        return query.getResultList();
    }

    public List<CmOrganization> findAll(CmOrganization organization) {
        try {
            Query query = entityManager().createNamedQuery("findAllOrganization");
            query.setParameter("path", organization.getPathCode() + "#%");
            query.setParameter("id",organization.getId());
            query.setParameter("active", true);
            query.setHint("org.hibernate.cacheable", true);
            return query.getResultList();
        } catch (NoResultException e) {
            return new ArrayList<>(0);
        } catch (NullPointerException e) {
            return new ArrayList<>(0);
        }
    }
    public List<CmOrganization> findAll() {
        try {
            Query query = entityManager().createNamedQuery("findAllOrganization");
            query.setParameter("active", true);
            query.setHint("org.hibernate.cacheable", true);
            return query.getResultList();
        } catch (NoResultException e) {
            return new ArrayList<>(0);
        } catch (NullPointerException e) {
            return new ArrayList<>(0);
        }
    }

    public List<CmOrganization> findOrganizationByChildren(CmOrganization parent) {
        try {
            Query query = entityManager().createNamedQuery("findOrganizationByChildren");
            query.setParameter("parent", parent);
            query.setParameter("active", true);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public long countByName(CmOrganization organization) {
        try {
            Query query = entityManager().createNamedQuery("countOrganizationByName");
            query.setParameter("name", organization.getName());
            query.setParameter("parentId", organization.getParent().getId());
            return (long) query.getSingleResult();
        } catch (NoResultException e) {
            return 0l;
        } catch (NullPointerException e) {
            return 0l;
        }
    }

    public long countByCode(CmOrganization organization) {
        try {
            Query query = entityManager().createNamedQuery("countOrganizationByCode");
            query.setParameter("code", organization.getCodeDigit());
            return (long) query.getSingleResult();
        } catch (NoResultException e) {
            return 0l;
        } catch (NullPointerException e) {
            return 0l;
        }
    }

    public long countByCodeForEdit(CmOrganization organization) {
        try {
            Query query = entityManager().createNamedQuery("countOrganizationByCodeForEdit");
            query.setParameter("code", organization.getCodeDigit());
            query.setParameter("id", organization.getId());
            return (long) query.getSingleResult();
        } catch (NoResultException e) {
            return 0l;
        } catch (NullPointerException e) {
            return 0l;
        }
    }

    public long countByNameForEdit(CmOrganization organization) {
        try {
            Query query = entityManager().createNamedQuery("countOrganizationByNameForEdit");
            query.setParameter("id", organization.getId());
            query.setParameter("name", organization.getName());
            query.setParameter("parentId", organization.getParent().getId());
            return (long) query.getSingleResult();
        } catch (NoResultException e) {
            return 0l;
        } catch (NullPointerException e) {
            return 0l;
        }
    }

    public long countByNameOrCodeForEdit(CmOrganization organization) {
        try {
            Query query = entityManager().createNamedQuery("countOrganizationByNameOrCodeForEdit");
            query.setParameter("name", organization.getName());
            query.setParameter("code", organization.getCodeDigit());
            query.setParameter("parent", organization.getParent());
            query.setParameter("id", organization.getId());
            query.setParameter("active", true);
            return (long) query.getSingleResult();
        } catch (NoResultException e) {
            return 0l;
        } catch (NullPointerException e) {
            return 0l;
        }
    }

    public List<CmOrganization> findByIndependentAccounting() {
        Query query = entityManager().createNamedQuery("findByIndependentAccounting");
        query.setParameter("organizationNature", OrganizationNatureEnum.IndependentAccounting);
        query.setParameter("active", true);
        return query.getResultList();
    }

    public List<CmOrganization> findByIndependentAccountingAndAccounting() {
        Query query = entityManager().createNamedQuery("findByIndependentAccountingAndAccounting");
        query.setParameter("organizationNature", OrganizationNatureEnum.IndependentAccounting);
        query.setParameter("accounting", true);
        query.setParameter("active", true);
        return query.getResultList();
    }

    public List<CmOrganization> findByIndependentAccountingAndAccountingByParentOrganization(CmOrganization organization){
        Query query = entityManager().createNamedQuery("findByIndependentAccountingAndAccountingByParentOrganization");
        query.setParameter("pathCode", organization.getPathCode() + "%");
        query.setParameter("organizationNature", OrganizationNatureEnum.IndependentAccounting);
        query.setParameter("accounting", true);
        query.setParameter("active", true);
        return query.getResultList();
    }

    public List<CmOrganization> findOrganizationByIndependentAccounting(CmOrganization organization) {
        Query query = entityManager().createNamedQuery("findOrganizationByIndependentAccounting");
        query.setParameter("pathCode", organization.getPathCode() + "%");
        query.setParameter("organizationNature", OrganizationNatureEnum.IndependentAccounting);
        query.setParameter("active", true);
        return query.getResultList();
    }



    public List<CmOrganization> findOrganizationByIndependentAccountingOrDependent(CmOrganization organization) {
        Query query = entityManager().createNamedQuery("findOrganizationByIndependentAccountingOrDependent");
        query.setParameter("pathCode", organization.getPathCode() + "%");
        query.setParameter("organizationNature", OrganizationNatureEnum.IndependentAccounting);
        query.setParameter("secondOrganizationNature", OrganizationNatureEnum.Dependent);
        query.setParameter("active", true);
        return query.getResultList();
    }

    public List<CmOrganization> findOrganizationsByIndependentAccounting() {
        Query query = entityManager().createNamedQuery("findOrganizationsByIndependentAccounting");
        query.setParameter("organizationNature", OrganizationNatureEnum.IndependentAccounting);
        query.setParameter("active", true);
        return query.getResultList();
    }

    public List<CmOrganization> findOrganizationByIndependentAccountingOrderByPath(CmOrganization organization) {
        Query query = entityManager().createNamedQuery("findOrganizationByIndependentAccountingOrderByPath");
        query.setParameter("pathCode", organization.getPathCode() + "%");
        query.setParameter("organizationNature", OrganizationNatureEnum.IndependentAccounting);
        query.setParameter("active", true);
        return query.getResultList();
    }

    public List<CmOrganization> findOrganizationsByDependent(CmOrganization organization) {
        Query query = entityManager().createNamedQuery("findOrganizationByDependent");
        query.setParameter("pathCode", organization.getPathCode() + "%");
        query.setParameter("organizationNature", OrganizationNatureEnum.Dependent);
        query.setParameter("active", true);
        return query.getResultList();
    }

    public List<CmOrganization> findIndependentAccountOrganizationsByName(CmOrganization organization, String name) {
        try {
            Query query = entityManager().createNamedQuery("findIndependentAccountOrganizationsByName");
            query.setParameter("name", "%" + name + "%");
            query.setParameter("pathCode", organization.getPathCode() + "%");
            query.setParameter("organizationNature", OrganizationNatureEnum.IndependentAccounting);
            query.setParameter("active", true);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }

    }

    public List<CmOrganization> findIndependentAccountOrganizationsByCode(CmOrganization organization, Long code) {
        try {
            Query query = entityManager().createNamedQuery("findIndependentAccountOrganizationsByCode");
            query.setParameter("code", code);
            query.setParameter("pathCode", organization.getPathCode() + "%");
            query.setParameter("organizationNature", OrganizationNatureEnum.IndependentAccounting);
            query.setParameter("active", true);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }

    }

    /*public List<CmOrganization> findIndependentAccountOrgByName(String name) {
        try {
            Query query = getEntityManager().createNamedQuery("findIndependentAccountOrgByName");
            query.setParameter("name", "%" + name + "%");
            query.setParameter("organizationNature", OrganizationNatureEnum.IndependentAccounting);
            query.setParameter("active", true);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }

    }

    public List<CmOrganization> findIndependentAccountOrgByCode(Long code) {
        try {
            Query query = getEntityManager().createNamedQuery("findIndependentAccountOrgByCode");
            query.setParameter("code", code);
            query.setParameter("organizationNature", OrganizationNatureEnum.IndependentAccounting);
            query.setParameter("active", true);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }

    }*/

    public List<CmOrganization> findByIndependentAccountingWihoutCurrentOrganization(CmOrganization organization) {
        Query query = entityManager().createNamedQuery("findByIndependentAccountingWihoutCurrentOrganization");
        query.setParameter("id", organization.getId());
        query.setParameter("organizationNature", OrganizationNatureEnum.IndependentAccounting);
        query.setParameter("active", true);
        return query.getResultList();
    }



    public String findOrganizationNameById(Long id) {
        try {
            Query query = entityManager().createNamedQuery("findOrganizationNameById");
            query.setParameter("id", id);
            return (String) query.getSingleResult();
        } catch (Exception e) {
            return "";
        }
    }

    public List<CmOrganization> findLastLevelOrganization(String pathCode) {
        try {
            Query query = entityManager().createNamedQuery("findLastLevelOrganizationByPathcode");
            query.setParameter("pathcode", pathCode + "#%");
            query.setParameter("leaf", true);
            query.setParameter("active", true);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }
//    public List<CmOrganization> findByListNotifyMaster(TrNotifyMaster notifyMaster) {
//        try {
//            Query query = getEntityManager().createNamedQuery("findByListNotifyMaster");
//            query.setParameter("notifyMaster", notifyMaster);
//            query.setParameter("clazz", CmOrganization.class);
//            query.setParameter("active", true);
//            return query.getResultList();
//        } catch (NoResultException e) {
//            return null;
//        } catch (NullPointerException e) {
//            return null;
//        }
//    }

    /*public List<CmOrganization> findListIndependentAccountingByName(String name) {
        try {
            Query query = getEntityManager().createNamedQuery("findListIndependentAccountingByName");
            query.setParameter("name", "%" + name + "%");
            query.setParameter("organizationNature", OrganizationNatureEnum.IndependentAccounting);
            query.setParameter("active", true);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }

    }*/

    /*public List<CmOrganization> findListIndependentAccountingByCode(Long code) {
        try {
            Query query = getEntityManager().createNamedQuery("findListIndependentAccountingByCode");
            query.setParameter("code", code);
            query.setParameter("organizationNature", OrganizationNatureEnum.IndependentAccounting);
            query.setParameter("active", true);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }*/

    public long countByOrganizationKind(CmOrganizationKind organizationKind) {
        try {
            Query query = entityManager().createNamedQuery("countByOrganizationKind");
            query.setParameter("organizationKind", organizationKind);
            return (long) query.getSingleResult();
        } catch (NoResultException e) {
            return 0l;
        } catch (NullPointerException e) {
            return 0l;
        }
    }





    public List<CmOrganization> findOrganization(CmOrganization organization, String organizationName,
                                                 Long organizationCode, CmOrganizationKind organizationKind,
                                                 CmOrganizationType organizationType, OrganizationNatureEnum organizationNatureEnum,
                                                 boolean deActive, CmOrganization searchOrganization,
                                                 boolean accounting) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CmOrganization> criteriaQuery = criteriaBuilder.createQuery(CmOrganization.class);
        Root<CmOrganization> organizationRoot = criteriaQuery.from(CmOrganization.class);

        criteriaQuery.select(organizationRoot).distinct(true);
        Predicate predicate = criteriaBuilder.conjunction();

        if (organization != null && organization.getId() != null) {
            Predicate pa[] = new Predicate[2];
            pa[0] =criteriaBuilder.like(organizationRoot.get(CmOrganization_.pathCode), organization.getPathCode()+"#"+ "%");
            pa[1] = criteriaBuilder.equal(organizationRoot.get(CmOrganization_.pathCode), organization.getPathCode());
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.or(pa));
        }
        if (organizationName != null && !organizationName.isEmpty()) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.or(
                    criteriaBuilder.like(organizationRoot.get(CmOrganization_.name), "%" + PersianUTF.farsiRevision(organizationName) + "%"),
                    criteriaBuilder.like(organizationRoot.get(CmOrganization_.name), "%" + PersianUTF.arabicRevision(organizationName) + "%")
            ));
        }
        if (organizationCode != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(organizationRoot.get(CmOrganization_.codeDigit), organizationCode));
        }
        if (organizationKind != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(organizationRoot.get(CmOrganization_.organizationKind), organizationKind));
        }
        if (organizationType != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(organizationRoot.get(CmOrganization_.organizationType), organizationType));
        }
        if (organizationNatureEnum != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(organizationRoot.get(CmOrganization_.organizationNatureEnum), organizationNatureEnum));
        }
        if (!deActive){
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.isTrue(organizationRoot.get(CmOrganization_.active)));
        }
        if (searchOrganization!=null && searchOrganization.getId()!=null){
            predicate = criteriaBuilder.and(predicate,criteriaBuilder.like(organizationRoot.get(CmOrganization_.pathCode),searchOrganization.getPathCode()+"%"));
        }
        predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(organizationRoot.get(CmOrganization_.ACCOUNTING),accounting));

        criteriaQuery.where(predicate);
        criteriaQuery.orderBy(criteriaBuilder.asc(organizationRoot.get(CmOrganization_.codeDigit)));
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }



    public List<CmOrganization> findIndependentOrganizationsWithOrganizationAndOrganizationTypes(CmOrganization organization, List<CmOrganizationType> organizationTypes) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CmOrganization> criteriaQuery = criteriaBuilder.createQuery(CmOrganization.class);

        Root<CmOrganization> organizationRoot = criteriaQuery.from(CmOrganization.class);
        criteriaQuery.select(organizationRoot).distinct(true);

        Predicate predicate = criteriaBuilder.conjunction();
        predicate = criteriaBuilder.isTrue(organizationRoot.get(CmOrganization_.active));
        predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(organizationRoot.get(CmOrganization_.organizationNatureEnum),OrganizationNatureEnum.IndependentAccounting));

        if (organization != null && organization.getId() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.or(
                    criteriaBuilder.like(organizationRoot.get(CmOrganization_.pathCode), organization.getPathCode() + "#%"),
                    criteriaBuilder.equal(organizationRoot.get(CmOrganization_.id), organization.getId())
            ));
        }
        if (organizationTypes != null && !organizationTypes.isEmpty()) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.and(organizationRoot.get(CmOrganization_.organizationType).in(organizationTypes)));
        }

        criteriaQuery.where(predicate);
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /*public List<OrganizationCostCenterReportWrapper> findOrganizationCostCenterWrapperByOrganization(CmOrganization organization, CmCostCenter cmCostCenter) {
        try {

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<OrganizationCostCenterReportWrapper> criteriaQuery = criteriaBuilder.createQuery(OrganizationCostCenterReportWrapper.class);
            Root<CmOrganization> organizationRoot = criteriaQuery.from(CmOrganization.class);
            Join<CmOrganization, CmCostCenter> costCenterJoin = organizationRoot.join(CmOrganization_.costCenter, JoinType.LEFT);
            Join<CmCostCenter, CmCostCenterType> costCenterTypeJoin = costCenterJoin.join(CmCostCenter_.costCenterType, JoinType.LEFT);
            criteriaQuery.select(
                    criteriaBuilder.construct(
                            OrganizationCostCenterReportWrapper.class,
                            organizationRoot.get(CmOrganization_.codeDigit),
                            organizationRoot.get(CmOrganization_.name),
                            costCenterJoin.get(CmCostCenter_.code),
                            costCenterJoin.get(CmCostCenter_.name),
                            costCenterTypeJoin.get(CmCostCenterType_.name)
                    ));

            Predicate predicate = criteriaBuilder.conjunction();

            if (organization != null && organization.getId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.or(
                        criteriaBuilder.like(organizationRoot.get(CmOrganization_.pathCode), organization.getPathCode() + "#%"),
                        criteriaBuilder.equal(organizationRoot.get(CmOrganization_.id), organization.getId())
                ));
            }
            if (cmCostCenter != null && cmCostCenter.getId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(organizationRoot.get(CmOrganization_.costCenter), cmCostCenter));
            }

            criteriaQuery.where(predicate);
            Query query = entityManager.createQuery(criteriaQuery);
            return query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(0);
        }
    }*/

    public Long countActiveChildByParent(String pathCode) {
        try {
            Query query = entityManager().createNamedQuery("countActiveChildOrganizationByParent");
            query.setParameter("pathCode",pathCode + "#%");
            return (Long) query.getSingleResult();
        }catch (Exception e){
            return 0l;
        }
    }

    public long countOrganizationById(Long id){
        try {
            Query query = entityManager.createNamedQuery("countOrganizationById");
            query.setParameter("id",id);
            return (long) query.getSingleResult();
        }catch (NoResultException e){
            return 0l;
        }catch (NullPointerException e){
            return 0l;
        }

    }

    public void disableObjects(CmOrganization organization){
        try {
            Query query = entityManager().createNamedQuery("disableEnableOrganization");
            query.setParameter("active",false);
            query.setParameter("pathcode", organization.getPathCode());
            query.setParameter("pathCode", organization.getPathCode() + "#%");
            query.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void enableObjects(CmOrganization organization){
        try {
            Query query = entityManager().createNamedQuery("disableEnableOrganization");
            query.setParameter("active",true);
            query.setParameter("pathcode", organization.getPathCode());
            query.setParameter("pathCode", organization.getPathCode() + "#%");
            query.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }





    public void deleteNativeQuery(Long id){
        try {
            Query query = entityManager.createNativeQuery("DELETE FROM CM_ORGANIZATION WHERE ID IN (?1)");
            query.setParameter(1, id);
            query.executeUpdate();

        } catch (NoResultException e){
        } catch (NullPointerException e){
        }
    }

    /*public List<CmOrganization> findOrganizationsWithStatement(CmPersonnel personnel) {
        try {
            Query query = getEntityManager().createNamedQuery("findOrganizationsWithStatement");
            query.setParameter("personnel", personnel);
            query.setParameter("active", true);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }

    }*/

    public void organizationPathFix(CmOrganization organization,CmOrganization parentOrganization) {
        try {
            StoredProcedureQuery q = entityManager.createNamedStoredProcedureQuery("organizationPathFix");
            q.setParameter("P_ID", organization.getId());
            q.setParameter("P_Parent_ID_Old", parentOrganization.getId());
            q.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void organizationJSONAndPathFix(List<CmOrganization> organizationList) {
        try {
            StoredProcedureQuery q = entityManager.createNamedStoredProcedureQuery("organizationJSONPathFix");
            q.setParameter("P_Ids", stateToString(organizationList));
            q.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CmOrganization findParentOrganization() {
        try {
            Query query = entityManager().createNamedQuery("findParentOrganization");
            return (CmOrganization) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public String stateToString(List<CmOrganization> organizationList){
        StringBuilder builder = new StringBuilder();
        for (CmOrganization organization : organizationList) {
            builder.append(organization.getId() + ",");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
    public CmResultCountSP organizationValidation(Long id, Long checkParent){
        try {
            StoredProcedureQuery q = entityManager.createNamedStoredProcedureQuery("organizationValidation");
            q.setParameter("P_ID",id);
            q.setParameter("P_CHK_PARENT",checkParent);
            return (CmResultCountSP) q.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}