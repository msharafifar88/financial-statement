package ir.ac.specialReport.entity;



import ir.ac.common.entity.CmOrganization;
import ir.ac.core.entity.AbstractEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by majid on 6/6/17.
 */
@Entity
@Table(name = "AC_SPECIAL_REPORT")
@NamedQueries({
        @NamedQuery(name = "findAcColumnBySpecialReport",query = "select specialColumn from AcSpecialColumn specialColumn where specialColumn.specialReport=:specialReport"),
        @NamedQuery(name = "findAcRowBySpecialReport",query = "select specialRow from AcSpecialGroupBy specialRow where specialRow.specialReport=:specialReport"),
        @NamedQuery(name = "findAllSpecialReportByOrganizationAndPersonnelOrderByDateAndCode", query = "select specialReport from AcSpecialReport specialReport where specialReport.organization=:organization and specialReport.createdBy=:personnelId and specialReport.organization.active=:active order by specialReport.created , specialReport.code desc "),
        @NamedQuery(name = "countReportByName", query = "select count(specialReport) from AcSpecialReport specialReport where " +
                "specialReport.name like :name and specialReport.createdBy=:createdBy"),
        /*Find SpecialReport By ID*/
        @NamedQuery(name = "findSpecialReportById", query = "select specialReport from AcSpecialReport specialReport where specialReport.id=:id"),
        @NamedQuery(name = "countReportByNameForEdit",query = "select count(specialReport) from AcSpecialReport specialReport where specialReport.id not in :id and specialReport.name like :name and specialReport.createdBy=:createdBy ")
})
public class AcSpecialReport extends AbstractEntity {

    private Long id;
    private Long code;
    private Long codeDigit;
    private String name;
    private Boolean publicReport;
    private Set<AcSpecialGroupBy> groupBies;
    private Set<AcSpecialColumn> columns;
    private CmOrganization organization;
    private AcSpecialReportType specialReportType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "CODE")
    public Long getCode() {
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }

    @Column(name = "CODEDIGIT")
    public Long getCodeDigit() {
        return codeDigit;
    }
    public void setCodeDigit(Long codeDigit) {
        this.codeDigit = codeDigit;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "specialReport", fetch = FetchType.LAZY, orphanRemoval = true, cascade = {CascadeType.ALL})
    @OrderBy("index ASC")
    public Set<AcSpecialGroupBy> getGroupBies() {
        return groupBies;
    }
    public void setGroupBies(Set<AcSpecialGroupBy> groupBies) {
        this.groupBies = groupBies;
    }

    @OneToMany(mappedBy = "specialReport", fetch = FetchType.EAGER, orphanRemoval = true, cascade = {CascadeType.ALL})
    @OrderBy("index ASC")
    public Set<AcSpecialColumn> getColumns() {
        return columns;
    }
    public void setColumns(Set<AcSpecialColumn> columns) {
        this.columns = columns;
    }

    @Column(name = "IS_PUBLIC")
    public Boolean getPublicReport() {
        return publicReport;
    }
    public void setPublicReport(Boolean publicReport) {
        this.publicReport = publicReport;
    }

    @ManyToOne
    @JoinColumn(name = "CM_ORGANIZATION_ID")
    public CmOrganization getOrganization() {
        return organization;
    }
    public void setOrganization(CmOrganization organization) {
        this.organization = organization;
    }

    @ManyToOne
    @JoinColumn(name = "SPECIAL_REPORT_TYPE")
    public AcSpecialReportType getSpecialReportType() {
        return specialReportType;
    }
    public void setSpecialReportType(AcSpecialReportType specialReportType) {
        this.specialReportType = specialReportType;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AcSpecialReport that = (AcSpecialReport) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (organization != null ? !organization.equals(that.organization) : that.organization != null) return false;
        if (publicReport != null ? !publicReport.equals(that.publicReport) : that.publicReport != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (publicReport != null ? publicReport.hashCode() : 0);
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        return result;
    }
}
