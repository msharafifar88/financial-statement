package ir.ac.common.dao;

import ir.ac.common.entity.CmOrganizationType;
import ir.ac.core.dao.AbstractDAO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Created by majid on 6/23/16.
 */
@RequestScoped
public class OrganizationTypeDao extends AbstractDAO<CmOrganizationType> {

    @Inject
    protected EntityManager entityManager;

    @Override
    protected EntityManager entityManager() {
        return entityManager;
    }


    public CmOrganizationType findByKey(String code){
        try{
            Query query = entityManager().createNamedQuery("findOrganizationTypeByCode");
            query.setParameter("code",code);
            return (CmOrganizationType) query.getSingleResult();
        }catch (NullPointerException e){
            return null;
        }catch (NoResultException e){
            return null;
        }
    }
}
