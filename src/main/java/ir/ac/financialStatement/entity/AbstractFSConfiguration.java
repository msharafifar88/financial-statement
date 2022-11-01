package ir.ac.financialStatement.entity;

import ir.ac.common.entity.BaseFiscalyearEntity;
import ir.ac.common.entity.CmFiscalyear;
import ir.ac.common.entity.CmOrganization;
import ir.ac.core.entity.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@MappedSuperclass
public abstract  class AbstractFSConfiguration extends BaseFiscalyearEntity {

    private Long id;
    private String name;
    private Long code;
    private LocalDate start;
    private LocalDate end;
    private CmFiscalyear currentFiscalYear;
    private CmFiscalyear previousFiscalYear;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "CODE", nullable = false, unique = true)
    public Long getCode() {
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "START_DATE", nullable = false)
    public LocalDate getStart() {
        return start;
    }
    public void setStart(LocalDate start) {
        this.start = start;
    }

    @Column(name = "END_DATE", nullable = false)
    public LocalDate getEnd() {
        return end;
    }
    public void setEnd(LocalDate end) {
        this.end = end;
    }

    @ManyToOne
    @JoinColumn(name = "CURRENT_FISCALYEAR_ID", unique = false, nullable = false, insertable = true, updatable = true)
    public CmFiscalyear getCurrentFiscalYear() {
        return currentFiscalYear;
    }
    public void setCurrentFiscalYear(CmFiscalyear currentFiscalYear) {
        this.currentFiscalYear = currentFiscalYear;
    }

    @ManyToOne
    @JoinColumn(name = "PRV_FISCALYEAR_ID", unique = false, nullable = false, insertable = true, updatable = true)
    public CmFiscalyear getPreviousFiscalYear() {
        return previousFiscalYear;
    }
    public void setPreviousFiscalYear(CmFiscalyear previousFiscalYear) {
        this.previousFiscalYear = previousFiscalYear;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFSConfiguration that = (AbstractFSConfiguration) o;
        return Objects.equals(id, that.id) && Objects.equals(start, that.start) && Objects.equals(end, that.end) && Objects.equals(currentFiscalYear, that.currentFiscalYear) && Objects.equals(previousFiscalYear, that.previousFiscalYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start, end, currentFiscalYear, previousFiscalYear);
    }
}
