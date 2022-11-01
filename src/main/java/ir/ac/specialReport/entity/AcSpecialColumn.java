package ir.ac.specialReport.entity;

import ir.ac.specialReport.enumration.AccountBalanceTypeEnum;
import ir.ac.specialReport.enumration.RemainNatureInSpecialReport;
import ir.ac.specialReport.enumration.SpColumnType;


import javax.persistence.*;

/**
 * Created by majid on 6/6/17.
 */
@Entity
@Table(name = "AC_SPECIAL_REPORT_COLUMN")
public class AcSpecialColumn extends AcSpecialElement{

    private String columnName;
    private String columnTitle;
    private Boolean onlyPositive;
    private SpColumnType columnType = SpColumnType.Column;
    private String formula;
    private RemainNatureInSpecialReport remainNatureInSpecialReport;
    private AccountBalanceTypeEnum accountBalanceTypeEnum;
    private Boolean columnOrganization;

    public AcSpecialColumn() {
        columnOrganization = false;
    }

    @Column(name = "COLUMN_NAME")
    public String getColumnName() {
        return columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    @Column(name = "COLUMN_TITLE")
    public String getColumnTitle() {
        return columnTitle;
    }
    public void setColumnTitle(String columnTitle) {
        this.columnTitle = columnTitle;
    }

    @Column(name = "ONLY_POSITIVE")
    public Boolean getOnlyPositive() {
        return onlyPositive;
    }
    public void setOnlyPositive(Boolean onlyPositive) {
        this.onlyPositive = onlyPositive;
    }

    @Column(name = "COLUMN_TYPE")
    @Enumerated(EnumType.STRING)
    public SpColumnType getColumnType() {
        return columnType;
    }
    public void setColumnType(SpColumnType columnType) {
        this.columnType = columnType;
    }


    public String getFormula() {
        return formula;
    }
    public void setFormula(String formula) {
        this.formula = formula;
    }

    @Column(name = "REMAIN_NATURE")
    @Enumerated(EnumType.ORDINAL)
    public RemainNatureInSpecialReport getRemainNatureInSpecialReport() {
        return remainNatureInSpecialReport;
    }
    public void setRemainNatureInSpecialReport(RemainNatureInSpecialReport remainNatureInSpecialReport) {
        this.remainNatureInSpecialReport = remainNatureInSpecialReport;
    }

    @Column(name = "NATURE_IN_REPORT")
    @Enumerated(EnumType.ORDINAL)
    public AccountBalanceTypeEnum getAccountBalanceTypeEnum() {
        return accountBalanceTypeEnum;
    }
    public void setAccountBalanceTypeEnum(AccountBalanceTypeEnum accountBalanceTypeEnum) {
        this.accountBalanceTypeEnum = accountBalanceTypeEnum;
    }

    @Column(name = "COLUMN_ORGANIZATION")
    public Boolean getColumnOrganization() {
        return columnOrganization;
    }
    public void setColumnOrganization(Boolean columnOrganization) {
        this.columnOrganization = columnOrganization;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AcSpecialColumn)) return false;
        if (!super.equals(o)) return false;

        AcSpecialColumn that = (AcSpecialColumn) o;

        if (columnName != null ? !columnName.equals(that.columnName) : that.columnName != null) return false;
        if (columnTitle != null ? !columnTitle.equals(that.columnTitle) : that.columnTitle != null) return false;
        if (onlyPositive != null ? !onlyPositive.equals(that.onlyPositive) : that.onlyPositive != null) return false;
        if (columnType != that.columnType) return false;
        if (formula != null ? !formula.equals(that.formula) : that.formula != null) return false;
        if (remainNatureInSpecialReport != that.remainNatureInSpecialReport) return false;
        if (accountBalanceTypeEnum != that.accountBalanceTypeEnum) return false;
        return columnOrganization != null ? columnOrganization.equals(that.columnOrganization) : that.columnOrganization == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (columnName != null ? columnName.hashCode() : 0);
        result = 31 * result + (columnTitle != null ? columnTitle.hashCode() : 0);
        result = 31 * result + (onlyPositive != null ? onlyPositive.hashCode() : 0);
        result = 31 * result + (columnType != null ? columnType.hashCode() : 0);
        result = 31 * result + (formula != null ? formula.hashCode() : 0);
        result = 31 * result + (remainNatureInSpecialReport != null ? remainNatureInSpecialReport.hashCode() : 0);
        result = 31 * result + (accountBalanceTypeEnum != null ? accountBalanceTypeEnum.hashCode() : 0);
        result = 31 * result + (columnOrganization != null ? columnOrganization.hashCode() : 0);
        return result;
    }
}
