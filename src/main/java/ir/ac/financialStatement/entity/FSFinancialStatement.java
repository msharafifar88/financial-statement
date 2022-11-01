package ir.ac.financialStatement.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "FS_FINANCIAL_STATEMENT")


@NamedQueries({
        /*Find All JPQL*/
        @NamedQuery(name = "findAllFS", query = "SELECT f FROM FSFinancialStatement f"),
        /*Find By ID JPQL*/
        @NamedQuery(name = "findFSById", query = "SELECT f FROM FSFinancialStatement f WHERE f.id = :id"),
        /* find All By Fiscal Year Id*/
        @NamedQuery(name = "findFSAllByYearId", query = "SELECT f FROM FSFinancialStatement f WHERE f.cmFiscalyear.id = :fiscalyearId"),
})
public class FSFinancialStatement extends AbstractFSFinancialStatement {


}
