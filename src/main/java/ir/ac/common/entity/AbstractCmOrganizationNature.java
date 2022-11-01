package ir.ac.common.entity;

import ir.ac.core.entity.AbstractEntity;
import javax.persistence.*;

/**
 * Created by majid on 8/16/16.
 */
@MappedSuperclass
public abstract class AbstractCmOrganizationNature extends AbstractEntity {
    private Long id;
    private String key;
    private String name;

    public AbstractCmOrganizationNature() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "KEY", unique = true, nullable = false, insertable = true, updatable = false, precision = 10, scale = 0)
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    @Column(name = "NAME", unique = true, nullable = false, insertable = true, updatable = false, precision = 10, scale = 0)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractCmOrganizationNature)) return false;

        AbstractCmOrganizationNature that = (AbstractCmOrganizationNature) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
