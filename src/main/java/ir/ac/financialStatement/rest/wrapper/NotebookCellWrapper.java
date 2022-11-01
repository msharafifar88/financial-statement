package ir.ac.financialStatement.rest.wrapper;

import ir.ac.financialStatement.enumration.ColumnType;

public class NotebookCellWrapper implements Comparable<NotebookCellWrapper> {
    private String value;
    private ColumnType columnType;
    private String columnName;

    public NotebookCellWrapper(String value, ColumnType columnType, String columnName) {
        this.value = value;
        this.columnType = columnType;
        this.columnName = columnName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ColumnType getColumnType() {
        return columnType;
    }

    public void setColumnType(ColumnType columnType) {
        this.columnType = columnType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }




    @Override
    public int compareTo(NotebookCellWrapper o) {
        return this.columnName.compareTo(o.columnName);
    }
}
