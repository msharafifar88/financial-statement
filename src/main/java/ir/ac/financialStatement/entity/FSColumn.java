package ir.ac.financialStatement.entity;

import javax.persistence.*;

@Entity
@Table(name = "FS_COLUMN")
@NamedQueries({
        @NamedQuery(name = "findAllColumns", query = "SELECT c FROM FSColumn c"),
})
public class FSColumn extends AbstractFSColumn {

}
