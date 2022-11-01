package ir.ac.common.entity;

import ir.ac.common.enumration.NumberTypeEnum;
import ir.ac.core.entity.AbstractEntity;

import javax.persistence.*;

/**
 * Created by Mohsen Mostafavi on 7/2/2016.
 */
@MappedSuperclass
public abstract class AbstractCmUnit extends AbstractEntity implements Comparable<AbstractCmUnit>{

    private Long id;
    private Long codeDigit;
    private String name;
    private String symbol;
    private String latinName;
    private NumberTypeEnum numberTypeEnum;

    public AbstractCmUnit() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, insertable = true, updatable = false, precision = 10, scale = 0)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "CODE" ,unique = true,nullable = false,insertable = true,updatable = false)
    public Long getCodeDigit() {
        return codeDigit;
    }
    public void setCodeDigit(Long codeDigit) {
        this.codeDigit = codeDigit;
    }

    @Transient
    public String getCode() {
        return String.valueOf(codeDigit);
    }


    @Column(name = "NAME",unique = true,nullable = false,insertable = true,updatable = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SYMBOL", unique = false, nullable = true, insertable = true, updatable = true, length = 30)
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Column(name = "LATIN_NAME" ,nullable = true)
    public String getLatinName() {
        return latinName;
    }
    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "NUMBER_TYPE")
    public NumberTypeEnum getNumberTypeEnum() {
        return numberTypeEnum;
    }
    public void setNumberTypeEnum(NumberTypeEnum numberTypeEnum) {
        this.numberTypeEnum = numberTypeEnum;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractCmUnit that = (AbstractCmUnit) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (codeDigit != null ? !codeDigit.equals(that.codeDigit) : that.codeDigit != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (symbol != null ? !symbol.equals(that.symbol) : that.symbol != null) return false;
        if (latinName != null ? !latinName.equals(that.latinName) : that.latinName != null) return false;
        return numberTypeEnum == that.numberTypeEnum;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (codeDigit != null ? codeDigit.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + (latinName != null ? latinName.hashCode() : 0);
        result = 31 * result + (numberTypeEnum != null ? numberTypeEnum.hashCode() : 0);
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
    public int compareTo(AbstractCmUnit unit) {
        if (this.getId()!=null) {
            return this.getCode().compareTo(unit.getCode());
        }else {
            return 0 ;
        }
    }
}
