package ir.ac.common.service;


import ir.ac.common.dao.FiscalyearDao;
import ir.ac.common.entity.CmFiscalyear;
import ir.ac.core.exception.DuplicateDataException;
import ir.ac.core.exception.RelationDataException;
import ir.ac.core.exception.SaveRecordException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by majid on 7/16/16.
 */
@RequestScoped
public class FiscalyearService  {
    
    @Inject
    FiscalyearDao fiscalyearDao;
    
    public boolean canSave(){
        return true;
    }

    public CmFiscalyear create(CmFiscalyear fiscalyear) throws DuplicateDataException, SaveRecordException {
        if (canSave()){
            return fiscalyearDao.create(fiscalyear);
        }
        return null;
    }

    public void edit(CmFiscalyear fiscalyear) throws  DuplicateDataException, RelationDataException,SaveRecordException {

            fiscalyearDao.edit(fiscalyear);

    }
    public void delete(Long id) throws RelationDataException, SaveRecordException {
        delete(fiscalyearDao.findByID(id));
    }

    public void delete(CmFiscalyear fiscalyear){
        try {

            fiscalyearDao.delete(fiscalyear);
        }catch (Exception e) {
            //logger.error("Delete Failed", e);
        }
    }


    /* Find Year By ID*/
    public CmFiscalyear findByID(Long id){
        return fiscalyearDao.findByID(id);
    }
    public List<CmFiscalyear> findAll(){
        try {
            return fiscalyearDao.findAllSortByYear();
        }catch (Exception e){
            //logger.error("No Result" , e);
            return new ArrayList<>(0);
        }
    }


    public CmFiscalyear findCurrentFiscalYear(){
        return fiscalyearDao.findCurrentFiscalYear();
    }

    public List<CmFiscalyear> findCurrentFiscalYears(){
        return fiscalyearDao.findCurrentFiscalYears();
    }

    public CmFiscalyear findYearByDate(Date date){
        return fiscalyearDao.findYearByDate(date);
    }

    public Long countYearByDate(Date date){

        return fiscalyearDao.countByFiscalYear(date);
    }

    public boolean canSave(CmFiscalyear fiscalyear){
        try {
            long count = fiscalyearDao.countByNameOrCode(fiscalyear.getName(),fiscalyear.getCode());
            if (count == 0l)
                return true;
            else
                return false;
        }catch (Exception e){
            return false;
        }
    }



    public List<CmFiscalyear> findAllSortByYear(){
        return fiscalyearDao.findAllSortByYear();
    }

    public CmFiscalyear findNextFiscalYear(CmFiscalyear fiscalyear){
        try {
            return fiscalyearDao.findNextFiscalYear(fiscalyear);
        }catch (Exception e){
            e.printStackTrace();
            return new CmFiscalyear();
        }
    }

    public CmFiscalyear findPrevFiscalYear(CmFiscalyear fiscalyear, LocalDate date){
        try {
            return fiscalyearDao.findPrevFiscalYear(fiscalyear);
        }catch (Exception e){
            return new CmFiscalyear();
        }
    }



    public Long countTotalFiscalyear() {
        return fiscalyearDao.countTotalFiscalyear();
    }

    public CmFiscalyear findLastFiscalYear() {
        return fiscalyearDao.findLastFiscalYear();
    }

    public Date findFirstDateOfFirstFiscalyear(){
        try{
            return fiscalyearDao.findFirstDateOfFirstFiscalyear();
        }catch (Exception e){
            return new Date();
        }
    }


}
