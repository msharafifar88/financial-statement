package ir.ac.specialReport.service;

import ir.ac.specialReport.dao.AccountingSpecialDao;
import ir.ac.specialReport.entity.AcSpecialReport;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class AccountingSpecialService {
    @Inject
    private AccountingSpecialDao accountingSpecialDao;

    public AcSpecialReport findByID(Long id) {
        return accountingSpecialDao.findByID(id);
    }

}
