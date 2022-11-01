package ir.ac.financialStatement.enumration;


import ir.ac.core.interfaces.Enumable;

import java.util.Arrays;
import java.util.List;

public enum NoteBookType implements Enumable {

    Name("Name", "message.common.unit.name"),
    Calculation("Calculation", "message.common.unit.calculation"),
    DataType("DataType", "message.common.unit.dataType"),
    InsertionDate("InsertionDate", "message.common.unit.insertionDate");

    private final String key;
    private final String label;

    NoteBookType(String key, String label) {
        this.key = key;
        this.label = label;
    }


    @Override
    public int getOrdinal(String key) {
        if (key.equals(Name.getKey())) {
            return NoteBookType.Name.ordinal();
        } else if (key.equals(Calculation.getKey())) {
            return NoteBookType.Calculation.ordinal();
        } else if (key.equals(DataType.getKey())) {
            return NoteBookType.DataType.ordinal();
        } else {
            return NoteBookType.InsertionDate.ordinal();
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

    public static List<NoteBookType> findAll() {
        return Arrays.asList(values());
    }

    public static NoteBookType getValue(String key) {
        if (key.equals(Name.getKey())) {
            return NoteBookType.Name;
        } else if (key.equals(Calculation.getKey())) {
            return NoteBookType.Calculation;
        } else if (key.equals(DataType.getKey())) {
            return NoteBookType.DataType;
        } else {
            return NoteBookType.InsertionDate;
        }
    }

}