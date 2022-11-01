package ir.ac.financialStatement.dao;

import ir.ac.core.dao.AbstractDAO;
import ir.ac.financialStatement.entity.FSColumn;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class ColumnDAO extends AbstractDAO<FSColumn> {

    @Inject
    protected EntityManager entityManager;
    @Override
    protected EntityManager entityManager() {
        return entityManager;
    }

    public List<FSColumn> findAll() {
        try {
            Query query = entityManager().createNamedQuery("findAllColumns");
            //query.setParameter("financialStatement", financialStatement);
            return query.getResultList();
        } catch (NullPointerException e) {
            return new ArrayList<>(0);
        } catch (NoResultException e) {
            return new ArrayList<>(0);
        }
    }
}
