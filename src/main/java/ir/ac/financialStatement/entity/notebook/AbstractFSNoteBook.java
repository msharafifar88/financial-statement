package ir.ac.financialStatement.entity.notebook;

import ir.ac.core.entity.AbstractEntity;
import ir.ac.financialStatement.entity.FSInformation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class AbstractFSNoteBook extends AbstractEntity {
    private Long id;
    private FSInformation information;
//    private NoteBookType type;
    private String name;
    private Long code;
    private FSNoteBook parent;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "INFORMATION_ID", nullable = false)
    public FSInformation getInformation() {
        return information;
    }
    public void setInformation(FSInformation information) {
        this.information = information;
    }

    /*@Enumerated(EnumType.ORDINAL)
    @Column(name = "TYPE", nullable = false)
    public NoteBookType getType() {
        return type;
    }
    public void setType(NoteBookType type) {
        this.type = type;
    }*/

    @NotNull
    @Column(name = "NAME", unique = true, nullable = false, insertable = true, updatable = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "CODE", unique = true, nullable = true, insertable = true, updatable = true)
    public Long getCode() {
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PARENT_ID", nullable = true)
    public FSNoteBook getParent() {
        return parent;
    }
    public void setParent(FSNoteBook parent) {
        this.parent = parent;
    }


}
