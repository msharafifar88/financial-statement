package ir.ac.financialStatement.entity.notebook;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "FS_NOTEBOOK")
@NamedQueries({
        @NamedQuery(name = "findAllNotebook", query = "SELECT nb FROM FSNoteBook nb"),
        @NamedQuery(name = "findNotebookByID",query = "select nb from FSNoteBook nb where nb.id=:id"),

})
public class FSNoteBook extends AbstractFSNoteBook {


}
