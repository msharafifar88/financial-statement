package ir.ac.financialStatement.entity.notebook;

import ir.ac.financialStatement.entity.AbstractFSCell;

import javax.persistence.*;

@Entity
@Table(name = "FS_NOTEBOOK_CELL")
public class FSNotebookCell extends AbstractFSCell {
    private FSNoteBookRow row;
    private FSNoteBookColumn column;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROW_ID")
    public FSNoteBookRow getRow() {
        return row;
    }
    public void setRow(FSNoteBookRow row) {
        this.row = row;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COLUMN_ID")
    public FSNoteBookColumn getColumn() {
        return column;
    }
    public void setColumn(FSNoteBookColumn column) {
        this.column = column;
    }
}
