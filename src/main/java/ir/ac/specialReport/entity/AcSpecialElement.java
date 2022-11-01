package ir.ac.specialReport.entity;


import ir.ac.common.entity.CmIndependentAccount;
import ir.ac.common.entity.CmOrganization;
import ir.ac.common.entity.CmOrganizationType;
import ir.ac.core.entity.AbstractEntity;
import ir.ac.specialReport.enumration.IndependentAccountEnum;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.Objects;

/**
 * Created by majid on 6/6/17.
 */
@MappedSuperclass
public abstract class AcSpecialElement extends AbstractEntity implements Comparable<AcSpecialElement>{

    private Long id;
    private CmOrganization organization;
    private CmOrganizationType organizationType;
    private CmIndependentAccount independentAccount;

    private String condition;
    private String conditionText;
    private Boolean visible = true;
    private AcSpecialReport specialReport;
    private Integer index;
    private IndependentAccountEnum independentAccountEnum;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "Independent_Account_ID")
    public CmIndependentAccount getIndependentAccount() {
        return independentAccount;
    }
    public void setIndependentAccount(CmIndependentAccount independentAccount) {
        this.independentAccount = independentAccount;
    }
    @ManyToOne
    @JoinColumn(name = "CM_ORGANIZATION_ID")
    public CmOrganization getOrganization() {
        return organization;
    }
    public void setOrganization(CmOrganization organization) {
        this.organization = organization;
    }

    @ManyToOne
    @JoinColumn(name = "ORGANIZATION_TYPE_ID")
    public CmOrganizationType getOrganizationType() {
        return organizationType;
    }
    public void setOrganizationType(CmOrganizationType organizationType) {
        this.organizationType = organizationType;
    }

    @Column(name = "ISVISIBLE")
    public Boolean getVisible() {
        return visible;
    }
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Column(name = "CONDITION_TEXT")
    public String getConditionText() {
        return conditionText;
    }
    public void setConditionText(String conditionText) {
        this.conditionText = conditionText;
    }

    @ManyToOne
    @JoinColumn(name = "MASTER_ID" )
    @JsonbTransient
    public AcSpecialReport getSpecialReport() {
        return specialReport;
    }
    public void setSpecialReport(AcSpecialReport specialReport) {
        this.specialReport = specialReport;
    }

    @Column(name = "POSITION")
    public Integer getIndex() {
        return index;
    }
    public void setIndex(Integer index) {
        this.index = index;
    }

    @Column(name = "INDEPENDENT_ACCOUNT_ENUM")
    public IndependentAccountEnum getIndependentAccountEnum() {
        return independentAccountEnum;
    }
    public void setIndependentAccountEnum(IndependentAccountEnum independentAccountEnum) {
        this.independentAccountEnum = independentAccountEnum;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcSpecialElement that = (AcSpecialElement) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(organization, that.organization) &&
                Objects.equals(organizationType, that.organizationType) &&
                Objects.equals(independentAccount, that.independentAccount) &&
                Objects.equals(visible, that.visible) &&
                Objects.equals(index, that.index) &&
                independentAccountEnum == that.independentAccountEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, organization, organizationType, independentAccount, visible, index, independentAccountEnum);
    }

    @Override
    public int compareTo(AcSpecialElement element) {
        return this.getIndex().compareTo(element.getIndex());
    }
}
