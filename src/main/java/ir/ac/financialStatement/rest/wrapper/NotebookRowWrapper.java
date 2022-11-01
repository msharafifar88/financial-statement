package ir.ac.financialStatement.rest.wrapper;

import java.util.List;

public class NotebookRowWrapper {

    private Long ID;

    private int index;

    private List<NotebookCellWrapper> columns;

    public NotebookRowWrapper(Long ID, int index,List<NotebookCellWrapper> columns) {
        this.ID = ID;
        this.index = index;
        this.columns = columns;
    }

    public Long getID() {
        return ID;
    }
    public void setID(Long ID) {
        this.ID = ID;
    }

    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    public List<NotebookCellWrapper> getColumns() {
        return columns;
    }
    public void setColumns(List<NotebookCellWrapper> columns) {
        this.columns = columns;
    }
}
