package ir.ac.financialStatement.entity;

import javax.persistence.*;

@Entity
@Table(name = "FS_ROW")
@NamedQueries({
        @NamedQuery(name = "findAllRows", query = "SELECT r FROM FSRow r"),
})
public class FSRow extends AbstractFSRow {
    private FSFinancialStatement financialStatement;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FINANCIAL_STATEMENT_ID")
    public FSFinancialStatement getFinancialStatement() {
        return financialStatement;
    }

    public void setFinancialStatement(FSFinancialStatement financialStatement) {
        this.financialStatement = financialStatement;
    }
}
