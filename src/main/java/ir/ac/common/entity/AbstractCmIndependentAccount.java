package ir.ac.common.entity;

import ir.ac.core.entity.AbstractEntity;
import ir.ac.core.enumration.EntityType;

import javax.persistence.*;

/**
 * Created by majid on 7/12/16.
 */
@MappedSuperclass
public abstract class AbstractCmIndependentAccount extends AbstractEntity implements Comparable<AbstractCmIndependentAccount>{

    private Long id;
    private String name;
    private Long code;
    private Class<?> clazz;
    private String query;
    private String tableName;
    private EntityType entityType;
    private boolean organizationRelated;
    private boolean fiscalyearRelated;
    private boolean favourite;
    private boolean onlyLeaf;
    private boolean participateBalanceControl;
    private boolean participateBudgetBalanceControl;
    private boolean free;
    private String orderBy;
    private String sanamaTagName;
    private boolean sanamaOnly;
    private String whereClause;
    private String accountIndependentItemWhereClause;
    private boolean likeOrgan;
    private boolean sanamaAccount;

    public AbstractCmIndependentAccount() {
        this.setActive(true);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "IndependentAccountSequenceGenerator")
    @Column(name = "ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "Name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Code")
    public Long getCode() {
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }

    @Column(name = "Class")
    public Class<?> getClazz() {
        return clazz;
    }
    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Column(name = "QUERY_STRING")
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }

    @Column(name = "DB_TABLE_NAME")
    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Column(name = "Entity_TYPE")
    public EntityType getEntityType() {
        return entityType;
    }
    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    @Column(name = "ORGANIZATION_RELATED", nullable = false)
    public Boolean getOrganizationRelated() {
        return organizationRelated;
    }
    public void setOrganizationRelated(Boolean organizationRelated) {
        this.organizationRelated = organizationRelated;
    }

    @Column(name = "FISCALYEAR_RELATED", nullable = false)
    public Boolean isFiscalyearRelated() {
        return fiscalyearRelated;
    }
    public void setFiscalyearRelated(Boolean fiscalyearRelated) {
        this.fiscalyearRelated = fiscalyearRelated;
    }

    @Column(name = "FAVOURITE", nullable = false)
    public boolean isFavourite() {
        return favourite;
    }
    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    @Column(name = "ONLYLEAF", nullable = false)
    public boolean isOnlyLeaf() {
        return onlyLeaf;
    }
    public void setOnlyLeaf(boolean onlyLeaf) {
        this.onlyLeaf = onlyLeaf;
    }

    @Column(name = "PARTICIPATE_BALANCE_CONTROL", nullable = false)
    public boolean isParticipateBalanceControl() {
        return participateBalanceControl;
    }
    public void setParticipateBalanceControl(boolean participateBalanceControl) {
        this.participateBalanceControl = participateBalanceControl;
    }

    @Column(name = "PARTICIPATE_BG_BALANCE_CONTROL", nullable = false)
    public boolean isParticipateBudgetBalanceControl() {
        return participateBudgetBalanceControl;
    }
    public void setParticipateBudgetBalanceControl(boolean participateBudgetBalanceControl) {
        this.participateBudgetBalanceControl = participateBudgetBalanceControl;
    }

    @Column(name = "FREE_INDEPENDENT_ACCOUNT", nullable = false)
    public boolean isFree() {
        return free;
    }
    public void setFree(boolean free) {
        this.free = free;
    }

    @Column(name = "ORDER_BY")
    public String getOrderBy() {
        return orderBy;
    }
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Column(name = "SANAMA_TAG_NAME")
    public String getSanamaTagName() {
        return sanamaTagName;
    }
    public void setSanamaTagName(String sanamaTagName) {
        this.sanamaTagName = sanamaTagName;
    }

    @Column(name = "SANAMA_ONLY")
    public boolean isSanamaOnly() {
        return sanamaOnly;
    }
    public void setSanamaOnly(boolean sanamaOnly) {
        this.sanamaOnly = sanamaOnly;
    }

    @Column(name = "WHERE_CLAUSE")
    public String getWhereClause() {
        return whereClause;
    }
    public void setWhereClause(String whereClause) {
        this.whereClause = whereClause;
    }

    @Column(name = "ITEM_WHERE_CLAUSE")
    public String getAccountIndependentItemWhereClause() {
        return accountIndependentItemWhereClause;
    }
    public void setAccountIndependentItemWhereClause(String accountIndependentItemWhereClause) {
        this.accountIndependentItemWhereClause = accountIndependentItemWhereClause;
    }

    @Column(name = "LIKE_ORGAN")
    public boolean isLikeOrgan() {
        return likeOrgan;
    }
    public void setLikeOrgan(boolean likeOragn) {
        this.likeOrgan = likeOragn;
    }

    @Column(name = "SANAMA_ACCOUNT", nullable = false)
    public boolean isSanamaAccount() {
        return sanamaAccount;
    }
    public void setSanamaAccount(boolean sanamaAccount) {
        this.sanamaAccount = sanamaAccount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractCmIndependentAccount)) return false;

        AbstractCmIndependentAccount that = (AbstractCmIndependentAccount) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (clazz != null ? !clazz.equals(that.clazz) : that.clazz != null) return false;
        if (query != null ? !query.equals(that.query) : that.query != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
        result = 31 * result + (query != null ? query.hashCode() : 0);
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(AbstractCmIndependentAccount independentAccount) {
        if (this.getId()!=null) {
            return this.getCode().compareTo(independentAccount.getCode());
        }else {
            return 0 ;
        }
    }
}
