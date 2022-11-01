package ir.ac.common.entity;

import ir.ac.core.entity.AbstractEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by majid on 6/23/16.
 */
@MappedSuperclass
public abstract class AbstractCmFiscalyear extends AbstractEntity implements Comparable<AbstractCmFiscalyear> {
    private Long id;
    private String code;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    // Constructors
    /** default constructor */
    public AbstractCmFiscalyear() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "CODE",unique = true,nullable = false)
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    @Column(name = "NAME",unique = true,nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "STARTDATE",unique = true,nullable = false)
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Column(name = "ENDDATE",unique = true,nullable = false)
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }


    @Transient
    public String getPathId(){
        return "#" + getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractCmFiscalyear)) return false;

        AbstractCmFiscalyear that = (AbstractCmFiscalyear) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        return endDate != null ? endDate.equals(that.endDate) : that.endDate == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        if (getCode() != null && getName() != null)
            return "(" + getCode() + ") "+ getName();
        else if (getCode() != null)
            return "(" + getCode() + ")";
        else if (getName() != null)
            return getName();
        else return "";
    }

    @Override
    public int compareTo(AbstractCmFiscalyear fiscalyear) {
        if (this.getId()!=null) {
            return this.getCode().compareTo(fiscalyear.getCode());
        }else {
            return 0 ;
        }
    }
}
