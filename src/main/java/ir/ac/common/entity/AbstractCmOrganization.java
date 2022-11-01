package ir.ac.common.entity;

import ir.ac.common.enumration.OrganizationNatureEnum;
import ir.ac.core.entity.AbstractEntity;


import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by majid on 6/23/16.
 */
@MappedSuperclass
public abstract class AbstractCmOrganization extends AbstractEntity implements Comparable<AbstractCmOrganization>{


    private Long id;
    private Long codeDigit;
    private String name;
    private CmOrganization parent;
    private String description;
    private OrganizationNatureEnum organizationNatureEnum;
    private CmOrganizationType organizationType;
    private CmOrganizationKind organizationKind;
    private Set<CmOrganization> children = new HashSet<CmOrganization>(0);
    private String pathCode;
    private String pathId;
    private Long parentId;
    private boolean leaf;
    private Date transferDate;
    private boolean accounting;

    // Constructors
    /** default constructor */
    public AbstractCmOrganization() {
        leaf = true;
    }

    // Property accessors

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "CODE", unique = true, nullable = false, insertable = true, updatable = true, length = 20)
    public Long getCodeDigit() {
        return codeDigit;
    }
    public void setCodeDigit(Long code) {
        this.codeDigit = code;
    }

    @Transient
    public String getCode(){
        return String.valueOf(codeDigit);
    }

    @NotNull
    @Column(name = "NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DESCRIPTION", unique = false, nullable = true, insertable = true, updatable = true)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "PATH_CODE")
    public String getPathCode() {
        return pathCode;
    }
    public void setPathCode(String pathCode) {
        this.pathCode = pathCode;
    }

    @Column(name = "PATH_ID")
    public String getPathId() {
        return pathId;
    }
    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

    @ManyToOne
    @JoinColumn(name = "PARENT_ID", foreignKey = @ForeignKey(name = "FK_PARENT_ORGANIZATION_ID"),unique = false, nullable = true, insertable = true, updatable = true)
    public CmOrganization getParent() {
        return parent;
    }
    public void setParent(CmOrganization parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent", cascade =CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonbTransient
    public Set<CmOrganization> getChildren() {
        return children;
    }
    public void setChildren(Set<CmOrganization> children) {
        this.children = children;
    }

    @ManyToOne (fetch = FetchType.EAGER,cascade = {})
    @JoinColumn(name = "organization_type_id",foreignKey = @ForeignKey(name = "FK_ORGANIZATION_TYPE_ID"),unique = false,nullable = true)
    public CmOrganizationType getOrganizationType() {
        return organizationType;
    }
    public void setOrganizationType(CmOrganizationType organizationType) {
        this.organizationType = organizationType;
    }

    @Column(name = "PARENT_ID", insertable = false, updatable = false)
    public Long getParentId() {
        return parentId;
    }
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Column(name = "LEAF",nullable = false)
    public boolean isLeaf() {
        return leaf;
    }
    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name="organization_nature_id")
    public OrganizationNatureEnum getOrganizationNatureEnum() {
        return organizationNatureEnum;
    }
    public void setOrganizationNatureEnum(OrganizationNatureEnum organizationNatureEnum) {
        this.organizationNatureEnum = organizationNatureEnum;
    }

    @Column(name = "TRANSFER_DATE")
    public Date getTransferDate() {
        return transferDate;
    }
    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    @ManyToOne
    @JoinColumn(name = "ORGANIZATION_KIND_ID", foreignKey = @ForeignKey(name = "FK_ORGANIZATION_KIND"))
    public CmOrganizationKind getOrganizationKind() {
        return organizationKind;
    }
    public void setOrganizationKind(CmOrganizationKind organizationKind) {
        this.organizationKind = organizationKind;
    }

    @Column(name = "ACCOUNTING")
    public boolean isAccounting() {
        return accounting;
    }
    public void setAccounting(boolean accounting) {
        this.accounting = accounting;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractCmOrganization)) return false;

        AbstractCmOrganization that = (AbstractCmOrganization) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (codeDigit != null ? !codeDigit.equals(that.codeDigit) : that.codeDigit != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (codeDigit != null ? codeDigit.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    @NotNull
    public int compareTo(AbstractCmOrganization organization) {
        if (this.getId()!=null) {
            return this.getCodeDigit().compareTo(organization.getCodeDigit());
        }else {
            return 0 ;
        }
    }

}
