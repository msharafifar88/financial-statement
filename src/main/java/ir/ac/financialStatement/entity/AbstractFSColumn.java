package ir.ac.financialStatement.entity;

import ir.ac.common.entity.CmUnit;
import ir.ac.core.entity.AbstractEntity;
import ir.ac.financialStatement.enumration.ColumnType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class AbstractFSColumn extends AbstractEntity {


    private Long id;
    private String name;
    private String title;
    private Boolean visible;
    private Integer priority ;
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
    @Column(name = "NAME", unique = true, nullable = false, insertable = true, updatable = true, length = 2000)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "TITLE", unique = false, nullable = false, insertable = true, updatable = true, length = 2000)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "VISIBLE", unique = false, nullable = false, insertable = true, updatable = true, length = 1)
    public Boolean getVisible() {
        return visible;
    }
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    @Column(name = "PRIORITY", unique = false, nullable = false, insertable = true, updatable = true, length = 2)
    public Integer getPriority() {
        return priority;
    }
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
