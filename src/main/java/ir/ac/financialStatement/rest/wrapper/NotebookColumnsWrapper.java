package ir.ac.financialStatement.rest.wrapper;



import ir.ac.financialStatement.enumration.ColumnType;
import ir.ac.specialReport.enumration.SpColumnType;

import java.util.Objects;

public class NotebookColumnsWrapper implements Comparable<NotebookColumnsWrapper> {

    private String columnName;
    private String columnTitle;
    private Boolean onlyPositive;
    private SpColumnType columnType;

    public NotebookColumnsWrapper(String columnName, String columnTitle,  SpColumnType columnType) {
        this.columnName = columnName;
        this.columnTitle = columnTitle;
        this.onlyPositive = true;
        this.columnType = columnType;
    }

    public NotebookColumnsWrapper(String columnName, String columnTitle  ) {
        this.columnName = columnName;
        this.columnTitle = columnTitle;
        this.onlyPositive = true;
        this.columnType = SpColumnType.Column;
    }
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnTitle() {
        return columnTitle;
    }

    public void setColumnTitle(String columnTitle) {
        this.columnTitle = columnTitle;
    }

    public Boolean getOnlyPositive() {
        return onlyPositive;
    }

    public void setOnlyPositive(Boolean onlyPositive) {
        this.onlyPositive = onlyPositive;
    }


    public SpColumnType getColumnType() {
        return columnType;
    }
    public void setColumnType(SpColumnType columnType) {
        this.columnType = columnType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotebookColumnsWrapper that = (NotebookColumnsWrapper) o;
        return Objects.equals(columnName, that.columnName) && Objects.equals(columnTitle, that.columnTitle) && Objects.equals(onlyPositive, that.onlyPositive) && columnType == that.columnType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnName, columnTitle, onlyPositive, columnType);
    }

    @Override
    public int compareTo(NotebookColumnsWrapper o) {
        return this.columnName.compareTo(o.getColumnName());
    }
}
