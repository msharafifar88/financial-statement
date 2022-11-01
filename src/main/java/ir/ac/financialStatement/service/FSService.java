package ir.ac.financialStatement.service;

import ir.ac.core.exception.DuplicateDataException;
import ir.ac.core.exception.RelationDataException;
import ir.ac.core.exception.SaveRecordException;
import ir.ac.financialStatement.dao.FSDao;
import ir.ac.financialStatement.entity.FSFinancialStatement;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class FSService {

    @Inject
    private FSDao fsDao;

    public List<FSFinancialStatement> findAll() {
            return fsDao.findAll();
        }

     /* Find By ID*/
    public FSFinancialStatement findByID(Long id) {
        return fsDao.findByID(id);
    }
    /* Create Method*/
    public FSFinancialStatement create(FSFinancialStatement fsFinancialStatement) {
        try {
            return fsDao.create(fsFinancialStatement);
        } catch (DuplicateDataException e) {
            throw new RuntimeException(e);
        } catch (SaveRecordException e) {
            throw new RuntimeException(e);
        }
    }

    /* Edit Method */
    public FSFinancialStatement edit(FSFinancialStatement fsFinancialStatement) {
        try {
            return fsDao.edit(fsFinancialStatement);
        } catch (DuplicateDataException e) {
            throw new RuntimeException(e);
        } catch (RelationDataException e) {
            throw new RuntimeException(e);
        }catch (SaveRecordException e) {
            throw new RuntimeException(e);
        }
    }
    /* Delete Method*/
    public boolean delete(Long id) {
        try {
            return fsDao.delete(id);
        } catch (RelationDataException e) {
            throw new RuntimeException(e);
        }
    }
}
