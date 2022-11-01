package ir.ac.common.entity;

import ir.ac.core.entity.AbstractEntity;
import javax.persistence.*;

/**
 * Created by majid on 9/4/17.
 */
@MappedSuperclass
public  abstract class AbstractCmOrganizationKind  extends AbstractEntity {
    private Long id;
    private Long code;
    private String name;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "CODE" , nullable = false,unique = true)
    public Long getCode() {
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }

    @Column(name = "NAME" ,nullable = false,unique = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractCmOrganizationKind)) return false;

        AbstractCmOrganizationKind that = (AbstractCmOrganizationKind) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
