package ir.ac.financialStatement.entity;

import ir.ac.financialStatement.enumration.ColumnType;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class AbstractFSCell {

    private Long id;
    private String value;
    private ColumnType columnType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "VALUE")
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "COLUMN_TYPE", unique = false, nullable = false, insertable = true, updatable = true, length = 1)
    public ColumnType getColumnType() {
        return columnType;
    }
    public void setColumnType(ColumnType columnType) {
        this.columnType = columnType;
    }
}
