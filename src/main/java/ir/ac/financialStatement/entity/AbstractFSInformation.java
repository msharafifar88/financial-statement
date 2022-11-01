package ir.ac.financialStatement.entity;

import ir.ac.core.entity.AbstractEntity;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractFSInformation extends AbstractEntity {


    private Long id;
    private String header;
    private String footer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "HEADER", unique = false, nullable = true, insertable = true, updatable = true, length = 4000)
    public String getHeader() {
        return header;
    }
    public void setHeader(String header) {
        this.header = header;
    }

    @Column(name = "FOOTER", unique = false, nullable = true, insertable = true, updatable = true, length = 4000)
    public String getFooter() {
        return footer;
    }
    public void setFooter(String footer) {
        this.footer = footer;
    }
}
