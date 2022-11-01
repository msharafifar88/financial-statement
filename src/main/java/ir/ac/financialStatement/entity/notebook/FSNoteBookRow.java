package ir.ac.financialStatement.entity.notebook;

import ir.ac.financialStatement.entity.AbstractFSRow;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "FS_NOTEBOOK_ROW")
@NamedQueries({
        @NamedQuery(name = "findNotebookRowByID",query = "select row from FSNoteBookRow  row where row.noteBook.id =:id")
})
public class FSNoteBookRow extends AbstractFSRow {
    private FSNoteBook noteBook;
    private Set<FSNotebookCell> notebookCells= new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NOTEBOOK_ID", nullable = false)
    public FSNoteBook getNoteBook() {
        return noteBook;
    }
    public void setNoteBook(FSNoteBook noteBook) {
        this.noteBook = noteBook;
    }

    @OneToMany(mappedBy = "row", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<FSNotebookCell> getNotebookCells() {
        return notebookCells;
    }
    public void setNotebookCells(Set<FSNotebookCell> notebookCells) {
        this.notebookCells = notebookCells;
    }
}
