package ir.ac.financialStatement.enumration;


import ir.ac.core.interfaces.Enumable;
import java.util.Arrays;
import java.util.List;

public enum ColumnType implements Enumable {

    Name("Name","message.common.unit.name"),
    Calculation("Calculation","message.common.unit.calculation"),
    DataType("DataType","message.common.unit.dataType"),
    InsertionDate("InsertionDate","message.common.unit.insertionDate");

    private final String key;
    private final String label;

    ColumnType(String key, String label) {
        this.key = key;
        this.label = label;
    }


    @Override
    public int getOrdinal(String key) {
        if (key.equals(Name.getKey())) {
            return ColumnType.Name.ordinal();
        } else if (key.equals(Calculation.getKey())) {
            return ColumnType.Calculation.ordinal();
        } else if (key.equals(DataType.getKey())) {
            return ColumnType.DataType.ordinal();
        } else {
            return ColumnType.InsertionDate.ordinal();
        }
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getLabel() {
        return label;
    }

    public static List<ColumnType> findAll() {
        return Arrays.asList(values());
    }

    public static ColumnType getValue(String key) {
        if (key.equals(Name.getKey())) {
            return ColumnType.Name;
        } else if (key.equals(Calculation.getKey())) {
            return ColumnType.Calculation;
        } else if (key.equals(DataType.getKey())) {
            return ColumnType.DataType;
        } else {
            return ColumnType.InsertionDate;
        }
    }



}
