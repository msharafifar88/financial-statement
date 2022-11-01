package ir.ac.financialStatement.dao;

import ir.ac.core.dao.AbstractDAO;
import ir.ac.financialStatement.entity.FSFinancialStatement;
import ir.ac.financialStatement.entity.FSRow;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class RowDAO extends AbstractDAO<FSRow> {

    @Inject
    protected EntityManager entityManager;

    @Override
    protected EntityManager entityManager() {
        return entityManager;
    }

    public List<FSRow> findAll() {
        try {
            Query query = entityManager().createNamedQuery("findAllRows");
            //query.setParameter("financialStatement", financialStatement);
            return query.getResultList();
        } catch (NullPointerException e) {
            return new ArrayList<>(0);
        } catch (NoResultException e) {
            return new ArrayList<>(0);
        }
    }

    /* find row by row group */
    /*public List<FSRow> findByRowGroup(FSFinancialStatement financialStatement, String rowGroup) {
        try {
            Query query = entityManager().createNamedQuery("findRowByRowGroup");
            query.setParameter("financialStatement", financialStatement);
            query.setParameter("rowGroup", rowGroup);
            return query.getResultList();
        } catch (NullPointerException e) {
            return new ArrayList<>(0);
        } catch (NoResultException e) {
            return new ArrayList<>(0);
        }
    }*/
}