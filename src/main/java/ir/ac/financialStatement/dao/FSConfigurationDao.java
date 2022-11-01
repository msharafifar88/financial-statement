package ir.ac.financialStatement.dao;

import ir.ac.core.dao.AbstractDAO;
import ir.ac.financialStatement.entity.FSConfiguration;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@RequestScoped
public class FSConfigurationDao extends AbstractDAO<FSConfiguration> {
    @Inject
    protected EntityManager entityManager;

    @Override
    protected EntityManager entityManager() {
        return entityManager;
    }

    public List<FSConfiguration> findAllConfigurationByYear(){
        try {
            Query query = entityManager().createNamedQuery("findAllConfiguration");
            //query.setParameter("year",fiscalyear);
            return query.getResultList();
        }catch (NullPointerException e){
            return null;
        }catch (NoResultException e){
            return null;
        }
    }

}
