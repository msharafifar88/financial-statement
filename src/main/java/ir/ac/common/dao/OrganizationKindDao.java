package ir.ac.common.dao;

import ir.ac.common.entity.CmOrganizationKind;
import ir.ac.core.dao.AbstractDAO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Created by majid on 9/4/17.
 */
@RequestScoped
public class OrganizationKindDao extends AbstractDAO<CmOrganizationKind> {

    @Inject
    protected EntityManager entityManager;

    @Override
    protected EntityManager entityManager() {
        return entityManager;
    }

    public Long findLastCode(){
        try {
            Query query = entityManager().createNamedQuery("findLastOrganizationKindCode");
            return (Long) query.getSingleResult();
        }
        catch (NoResultException e){
            return null;
        }catch (NullPointerException e){
            return null;
        }
    }

    public long countByNameOrCode(CmOrganizationKind organizationKind){
        try {
            Query query = entityManager().createNamedQuery("countOrganizationKindByNameOrCode");
            query.setParameter("name",organizationKind.getName());
            query.setParameter("code",organizationKind.getCode());
            return (long) query.getSingleResult();
        } catch (NoResultException e){
            return 0l;
        } catch (NullPointerException e){
            return 0l;
        }
    }

    public long countByNameOrCodeForEdit(CmOrganizationKind organizationKind){
        try {
            Query query = entityManager().createNamedQuery("countOrganizationKindByNameOrCodeForEdit");
            query.setParameter("id",organizationKind.getId());
            query.setParameter("name",organizationKind.getName());
            query.setParameter("code",organizationKind.getCode());
            return (long) query.getSingleResult();
        } catch (NoResultException e){
            return 0l;
        } catch (NullPointerException e){
            return 0l;
        }
    }
}
