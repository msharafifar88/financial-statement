package ir.ac.financialStatement.entity;

import ir.ac.common.entity.BaseOrganizationAndYearEntity;
import ir.ac.common.entity.CmFiscalyear;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@MappedSuperclass
public abstract class AbstractFSFinancialStatement extends BaseOrganizationAndYearEntity {

    private Long id;
    private Long code;
    private String name;
    private FSConfiguration configuration;
    private Set<FSRow> rows;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "CODE", unique = false, nullable = true, insertable = true, updatable = true, precision = 10, scale = 2)
    public Long getCode() {
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }

    @NotNull
    @Column(name = "NAME", unique = true, nullable = false, insertable = true, updatable = true, length = 20)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CONFIGURATION_ID", nullable = true)
    public FSConfiguration getConfiguration() {
        return configuration;
    }
    public void setConfiguration(FSConfiguration configuration) {
        this.configuration = configuration;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "financialStatement")
    public Set<FSRow> getRows() {
        return rows;
    }
    public void setRows(Set<FSRow> rows) {
        this.rows = rows;
    }
}
