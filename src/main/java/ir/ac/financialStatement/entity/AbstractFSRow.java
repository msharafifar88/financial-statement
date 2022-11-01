package ir.ac.financialStatement.entity;

import ir.ac.common.entity.CmUnit;
import ir.ac.core.entity.AbstractEntity;
import ir.ac.financialStatement.enumration.RowGroup;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class AbstractFSRow extends AbstractEntity {

    private Long id;
    private String name;
    private Long code;
    private CmUnit unit;
    private RowGroup rowGroup;

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
    @Column(name = "NAME", unique = true, nullable = false, insertable = true, updatable = true, length = 20)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "CODE", unique = false, nullable = true, insertable = true, updatable = true, precision = 10, scale = 2)
    public Long getCode() {
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ROW_GROUP", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
    public RowGroup getRowGroup() {
        return rowGroup;
    }
    public void setRowGroup(RowGroup rowGroup) {
        this.rowGroup = rowGroup;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UNIT_ID", nullable = true)
    public CmUnit getUnit() {
        return unit;
    }
    public void setUnit(CmUnit unit) {
        this.unit = unit;
    }
}
