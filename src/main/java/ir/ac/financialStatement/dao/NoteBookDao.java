package ir.ac.financialStatement.dao;

import ir.ac.core.dao.AbstractDAO;
import ir.ac.financialStatement.entity.notebook.FSNoteBook;
import ir.ac.financialStatement.entity.notebook.FSNoteBookColumn;
import ir.ac.financialStatement.entity.notebook.FSNoteBookRow;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RequestScoped
public class NoteBookDao extends AbstractDAO<FSNoteBook> {

    @Inject
    protected EntityManager entityManager;

    @Override
    protected EntityManager entityManager() {
        return entityManager;
    }

    public List<FSNoteBook> findAll() {
        Query query = entityManager.createNamedQuery("findAllNotebook");
        return query.getResultList();
    }
    public FSNoteBook findByID(Long id) {
        Query query = entityManager.createNamedQuery("findNotebookByID");
        query.setParameter("id",id);
        return (FSNoteBook) query.getSingleResult();
    }

    public List<FSNoteBookColumn> findColumnByID(Long id) {
        Query query = entityManager.createNamedQuery("findNotebookColumnByID");
        query.setParameter("id",id);
        return  query.getResultList();
    }
    public List<FSNoteBookRow> findRowByID(Long id) {
        Query query = entityManager.createNamedQuery("findNotebookRowByID");
        query.setParameter("id",id);
        return  query.getResultList();
    }


}
