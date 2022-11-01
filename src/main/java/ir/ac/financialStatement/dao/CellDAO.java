package ir.ac.financialStatement.dao;

import ir.ac.core.dao.AbstractDAO;
import ir.ac.financialStatement.entity.FSCell;
import ir.ac.financialStatement.entity.FSColumn;
import ir.ac.financialStatement.entity.FSRow;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@RequestScoped
public class CellDAO extends AbstractDAO<FSCell> {

    @Inject
    protected EntityManager entityManager;
    @Override
    protected EntityManager entityManager() {
        return entityManager;
    }

    // find cell by row and column
    public FSCell findByRowAndColumn(FSRow row , FSColumn column) {
        try {
            Query query = entityManager().createNamedQuery("findByRowAndColumn");
            query.setParameter("row", row);
            query.setParameter("column", column);
            return (FSCell) query.getSingleResult();
        } catch (NullPointerException e) {
            return null;
        } catch (NoResultException e) {
            return null;
        }
    }
}
