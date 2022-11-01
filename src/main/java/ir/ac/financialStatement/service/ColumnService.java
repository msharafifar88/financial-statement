package ir.ac.financialStatement.service;

import ir.ac.financialStatement.dao.ColumnDAO;
import ir.ac.financialStatement.entity.FSColumn;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class ColumnService {

    @Inject
    ColumnDAO columnDAO;

    /* Find All */
    public List<FSColumn> findAll() {
        return columnDAO.findAll();
    }
}
