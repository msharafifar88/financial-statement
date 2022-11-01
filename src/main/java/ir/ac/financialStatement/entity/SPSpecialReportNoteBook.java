package ir.ac.financialStatement.entity;

import ir.ac.core.entity.AbstractEntity;
import ir.ac.specialReport.entity.AcSpecialReport;

import javax.persistence.*;

@Entity
@Table(name="SP_SPECIAL_REPORT_NOTE_BOOK")
@NamedQueries({

        @NamedQuery(name = "findReportNotebookBySpecialReportId", query = "SELECT nb FROM SPSpecialReportNoteBook nb WHERE nb.specialReport.id = :specialReportId")
})

public class SPSpecialReportNoteBook extends AbstractEntity {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="TABLE_NAME")
    private String tableName;

    @Column(name="TABLE_TITLE")
    private String tableTitle;

    @Column(name="TABLE_DESCRIPTION")
    private String tableDescription;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="SPECIAL_REPORT_TYPE_ID")
    private AcSpecialReport specialReport;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableTitle() {
        return tableTitle;
    }
    public void setTableTitle(String tableTitle) {
        this.tableTitle = tableTitle;
    }

    public String getTableDescription() {
        return tableDescription;
    }
    public void setTableDescription(String tableDescription) {
        this.tableDescription = tableDescription;
    }

    public AcSpecialReport getSpecialReport() {
        return specialReport;
    }
    public void setSpecialReport(AcSpecialReport specialReport) {
        this.specialReport = specialReport;
    }
}
