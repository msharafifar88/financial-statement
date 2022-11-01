package ir.ac.common.dao;

import ir.ac.common.entity.CmFiscalyear;
import ir.ac.core.dao.AbstractDAO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by majidmostafavi on 8/20/15.
 */
@RequestScoped
public class FiscalyearDao extends AbstractDAO<CmFiscalyear> {

    @Inject
    protected EntityManager entityManager;

    @Override
    protected EntityManager entityManager() {
        return entityManager;
    }

    /*fond by ID*/
    public CmFiscalyear findByID(Long id) {
        Query query = entityManager().createNamedQuery("findYearById");
        query.setParameter("id", id);
        return (CmFiscalyear) query.getSingleResult();
    }


    public CmFiscalyear findCurrentFiscalYear(){
        try {
            Query query = entityManager().createNamedQuery("findYearByDate");
            query.setParameter("intendedDate", new Date());
//            query.setHint("org.hibernate.cacheable", true);
            return (CmFiscalyear) query.getSingleResult();
        } catch (NoResultException nre) {
           return null;
        }
    }

    public List<CmFiscalyear> findCurrentFiscalYears(){
        try {
            Query query = entityManager().createNamedQuery("findYearByDate");
            query.setParameter("intendedDate", new Date());
            return (List<CmFiscalyear>)query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public CmFiscalyear findYearByDate(Date date) {
        try {
            Query query = entityManager().createNamedQuery("findYearByDate");
            query.setParameter("intendedDate", date);
            query.setMaxResults(1);
            return (CmFiscalyear) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public CmFiscalyear findNextFiscalYear(CmFiscalyear fiscalYear) {
        try {
            LocalDateTime onDayInNextYear = fiscalYear.getEndDate().plusDays(2);
            Query query = entityManager().createNamedQuery("findYearByDate");
            query.setParameter("intendedDate", onDayInNextYear);
            return (CmFiscalyear) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public CmFiscalyear findPrevFiscalYear(CmFiscalyear fiscalYear) {
        try {
            LocalDateTime onDayInNextYear = fiscalYear.getEndDate().minusDays(2);
            Query query = entityManager().createNamedQuery("findYearByDate");
            query.setParameter("intendedDate", onDayInNextYear);
            return (CmFiscalyear) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }


    public long countByNameOrCode(String name, String code){
        try{
            Query query = entityManager().createNamedQuery("countFiscalyearByNameOrCode");
            query.setParameter("name",name);
            query.setParameter("code",code);
            return (long) query.getSingleResult();
        }catch (NoResultException e){
            return 0l;
        }catch (NullPointerException e){
            return 0l;
        }
    }

    public long countByFiscalYear(Date date){
        try{
            Query query = entityManager().createNamedQuery("countYearByDate");
            query.setParameter("intendedDate", date);
            return (long) query.getSingleResult();
        }catch (NoResultException e){
            return 0l;
        }catch (NullPointerException e){
            return 0l;
        }
    }

    public List<CmFiscalyear> findAllSortByYear(){
        Query query = entityManager.createNamedQuery("findAllSortByYear");
        query.setHint("org.hibernate.cacheable", true);
        return (List<CmFiscalyear>) query.getResultList();
    }

    public Long countTotalFiscalyear() {
        try{
            Query query = entityManager().createNamedQuery("countTotalFiscalyear");
            return (Long) query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return 0l;
        }
    }

    public CmFiscalyear findLastFiscalYear() {
        try{
            Query query = entityManager().createNamedQuery("findLastFiscalYear");
            return (CmFiscalyear) query.setMaxResults(1).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Date findFirstDateOfFirstFiscalyear() {
        try {
            Query query = entityManager().createNamedQuery("findFirstDateOfFirstFiscalyear");
            query.setMaxResults(1);
            return (Date) query.getSingleResult();
        } catch (NoResultException e){
            return null;
        } catch (NullPointerException e){
            return null;
        }
    }

}
