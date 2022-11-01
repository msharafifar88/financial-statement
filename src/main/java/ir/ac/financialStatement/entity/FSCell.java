package ir.ac.financialStatement.entity;

import javax.persistence.*;

@Entity
@Table(name = "FS_CELL")
@NamedQueries({
        @NamedQuery(name="findByRowAndColumn", query="SELECT c FROM FSCell c WHERE c.row = :row AND c.column = :column")
})
public class FSCell extends AbstractFSCell {
    private FSRow row;
    private FSColumn column;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROW_ID")
    public FSRow getRow() {
        return row;
    }
    public void setRow(FSRow row) {
        this.row = row;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COLUMN_ID")
    public FSColumn getColumn() {
        return column;
    }
    public void setColumn(FSColumn column) {
        this.column = column;
    }
}
