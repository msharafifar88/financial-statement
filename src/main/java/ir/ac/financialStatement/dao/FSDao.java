package ir.ac.financialStatement.dao;

import ir.ac.core.dao.AbstractDAO;
import ir.ac.financialStatement.entity.FSFinancialStatement;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class FSDao extends AbstractDAO<FSFinancialStatement> {

    @Inject
    protected EntityManager entityManager;

    @Override
    protected EntityManager entityManager() {
        return entityManager;
    }

    /*find By ID*/
    public FSFinancialStatement findByID(Long id) {
        Query query = entityManager().createNamedQuery("findFSById");
        query.setParameter("id", id);
        return (FSFinancialStatement) query.getSingleResult();
    }

    /* find All */
    public List<FSFinancialStatement> findAll() {
        try {
            Query query = entityManager().createNamedQuery("findAllFS");
            return query.getResultList();
        } catch (NullPointerException e) {
            return new ArrayList<>(0);
        } catch (NoResultException e) {
            return new ArrayList<>(0);
        }
    }
    /* Find All*/
    public List<FSFinancialStatement> findAll(Long fiscalyearId) {
        try {
            Query query = entityManager().createNamedQuery("findFSAllByYearId");
            query.setParameter("fiscalyearId", fiscalyearId);
            return query.getResultList();
        } catch (NullPointerException e) {
            return new ArrayList<>(0);
        } catch (NoResultException e) {
            return new ArrayList<>(0);
        }
    }
}
