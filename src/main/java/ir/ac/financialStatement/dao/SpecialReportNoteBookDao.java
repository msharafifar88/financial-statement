package ir.ac.financialStatement.dao;

import ir.ac.core.dao.AbstractDAO;
import ir.ac.financialStatement.entity.SPSpecialReportNoteBook;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RequestScoped
public class SpecialReportNoteBookDao extends AbstractDAO<SPSpecialReportNoteBook> {

    @Inject
    protected EntityManager entityManager;

    @Override
    protected EntityManager entityManager() {
        return entityManager;
    }
    /*Find By ID*/
    public SPSpecialReportNoteBook findById(Long id) {
        Query query = entityManager.createNamedQuery("findReportNotebookBySpecialReportId");
        query.setParameter("specialReportId", id);
        return (SPSpecialReportNoteBook) query.getSingleResult();
    }
    public List<Object[]> showResult(SPSpecialReportNoteBook nb ){

        Query q  = entityManager.createNativeQuery("SELECT * FROM "+nb.getTableName());

        /*org.hibernate.engine.spi.SessionImplementor sessionImp = (org.hibernate.engine.spi.SessionImplementor) entityManager.getDelegate();
        DatabaseMetaData metadata = null;
        try {
            metadata = sessionImp.connection().getMetaData();
            ResultSet res = metadata.getColumns(null, "nejat", "sf_2056", new String());
            System.out.println("List of columns: ");
            while (res.next()) {
                System.out.println(
                        "  " + res.getString("TABLE_SCHEM")
                                + ", " + res.getString("TABLE_NAME")
                                + ", " + res.getString("COLUMN_NAME")
                                + ", " + res.getString("TYPE_NAME")
                                + ", " + res.getInt("COLUMN_SIZE")
                                + ", " + res.getInt("NULLABLE"));
            }
            res.close();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        Stream<Object[]> resultList=q.getResultStream();
        entityManager.getMetamodel();
        q.getParameters().forEach(System.out::println);
        /* find result Table  */
        return resultList.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

    }
}
