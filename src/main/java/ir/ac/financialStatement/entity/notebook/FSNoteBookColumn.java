package ir.ac.financialStatement.entity.notebook;

import ir.ac.financialStatement.entity.AbstractFSColumn;

import javax.persistence.*;

@Entity
@Table(name = "FS_NOTEBOOK_COLUMN")
@NamedQueries({
        @NamedQuery(name = "findNotebookColumnByID", query = "select column from FSNoteBookColumn column where column.noteBook.id=:id order by column.priority")
})
public class FSNoteBookColumn extends AbstractFSColumn {

    private FSNoteBook noteBook;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NOTEBOOK_ID", nullable = false)
    public FSNoteBook getNoteBook() {
        return noteBook;
    }
    public void setNoteBook(FSNoteBook noteBook) {
        this.noteBook = noteBook;
    }
}
