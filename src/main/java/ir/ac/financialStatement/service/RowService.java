package ir.ac.financialStatement.service;

import ir.ac.financialStatement.dao.RowDAO;
import ir.ac.financialStatement.entity.FSFinancialStatement;
import ir.ac.financialStatement.entity.FSRow;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class RowService   {
    @Inject
    RowDAO rowDAO;

    /* Find row by Financial Statement*/
    public List<FSRow> findAll() {
        return rowDAO.findAll();
    }


}
