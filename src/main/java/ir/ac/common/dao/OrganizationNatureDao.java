package ir.ac.common.dao;

import ir.ac.common.entity.CmOrganizationNature;
import ir.ac.core.dao.AbstractDAO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Created by armita on 2/14/17.
 */
@RequestScoped
public class OrganizationNatureDao extends AbstractDAO<CmOrganizationNature> {

    @Inject
    protected EntityManager entityManager;

    @Override
    protected EntityManager entityManager() {
        return entityManager;
    }

    public CmOrganizationNature findByKey(String key){
        try{
            Query query = entityManager().createNamedQuery("findOrganizationNatureByKey");
            query.setParameter("natureKey",key);
            return (CmOrganizationNature) query.getSingleResult();
        }catch (NullPointerException e){
            return null;
        }catch (NoResultException e){
            return null;
        }
    }

}
