package ir.ac.common.entity;

import ir.ac.core.entity.AbstractEntity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by majid on 6/23/16.
 */
@MappedSuperclass
public abstract class AbstractCmOrganizationType extends AbstractEntity implements Comparable<AbstractCmOrganizationType>{

    private Long id;
    private String code;
    private String name;
//    private String key;

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
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "NAME" ,nullable = false,unique = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

//    @Column(name = "KEY" , nullable = false , unique = true)
//    public String getKey() {
//        return key;
//    }
//    public void setKey(String key) {
//        this.key = key;
//    }

    @Transient
    public String getPathId(){
        return "#" + getId();
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof AbstractCmOrganizationType)) return false;
//
//        AbstractCmOrganizationType that = (AbstractCmOrganizationType) o;
//
//        if (id != null ? !id.equals(that.id) : that.id != null) return false;
//        if (code != null ? !code.equals(that.code) : that.code != null) return false;
//        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//        return key != null ? key.equals(that.key) : that.key == null;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (code != null ? code.hashCode() : 0);
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (key != null ? key.hashCode() : 0);
//        return result;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCmOrganizationType that = (AbstractCmOrganizationType) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name);
    }

    @Override
    public String toString() {
        if (getCode() != null && getName() != null)
            return "(" + getCode() + ") "+ getName();
        else if (getCode() != null)
            return "(" + getCode() + ")";
        else if (getName() != null)
            return getName();
        else return "";
    }

    @Override
    public int compareTo(AbstractCmOrganizationType organizationType) {
        if (this.getId()!=null) {
            return this.getCode().compareTo(organizationType.getCode());
        }else {
            return 0 ;
        }
    }
}
